package dev.gadekryds.common;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Bus implements Mediator {

    private final Map<String, RequestHandler<?, ?>> requestHandlers = new ConcurrentHashMap<>();
    private final Map<String, List<NotificationHandler<?>>> notificationHandlers = new ConcurrentHashMap<>();
    public Bus(ApplicationContext ctx) {
        setupNotificationHandlersMap(ctx);
        setupRequestHandlersMap(ctx);
    }

    private void setupRequestHandlersMap(ApplicationContext ctx) {
        var handlerBeans = ctx.getBeansOfType(RequestHandler.class);
        for (var entry : handlerBeans.entrySet()) {
            Type[] interfaces = entry.getValue().getClass()
                    .getGenericInterfaces();
            for (var itf : interfaces) {
                var ptype = ((ParameterizedType) itf).getActualTypeArguments()[1];
                requestHandlers.put(ptype.getTypeName(), (RequestHandler<?, ?>) entry.getValue());
            }
        }
    }

    private void setupNotificationHandlersMap(ApplicationContext ctx) {
        var handlerBeans = ctx.getBeansOfType(NotificationHandler.class);
        for (var entry : handlerBeans.entrySet()) {
            Type[] interfaces = entry.getValue().getClass()
                    .getGenericInterfaces();
            for (var itf : interfaces) {
                var ptype = ((ParameterizedType) itf).getActualTypeArguments()[1];
                if (notificationHandlers.containsKey(ptype.getTypeName())) {
                    notificationHandlers.get(ptype.getTypeName()).add(entry.getValue());
                } else {
                    notificationHandlers.put(ptype.getTypeName(), List.of((NotificationHandler<?>) entry.getValue()));
                }
            }
        }
    }

    @Override
    public <T> Response<T> request(Request<T> request) {
        Response<T> response = new Response<>();
        try {
            RequestPlan<T> plan = new RequestPlan<>(
                    this.requestHandlers.get(request.getClass().getTypeName()),
                    request.getClass());
            response.data = plan.invoke(request);
        } catch (Exception e) {
            response.exception = e;
        }
        return response;
    }
    @Override
    @SuppressWarnings("unchecked")
    public Response<Void> notify(Notification notification) {
        Response<Void> response = new Response<>();

        List<Exception> exceptions = null;
        var hs = this.notificationHandlers.get(notification.getClass().getTypeName());
        for (var handler : hs) {
            try {
                ((NotificationHandler<Notification>) handler).handle(notification);
            } catch (Exception e) {
                if (exceptions == null) {
                    exceptions = new ArrayList<>();
                }
                exceptions.add(e);
            }
        }

        if (exceptions != null) {
            response.exception = new AggregateException(exceptions);
        }

        return response;
    }


    class RequestPlan<T> {
        private final Method handleMethod;
        private final Object handlerInstanceBuilder;

        public RequestPlan(RequestHandler<?, ?> handler, Class<?> messageType) throws NoSuchMethodException {
            handleMethod = handler.getClass().getMethod("Handle", messageType);
            handlerInstanceBuilder = handler;
        }


        @SuppressWarnings("unchecked")
        public T invoke(Request<T> request)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

            var req = (T) request;
            IO.println("This: " + request.toString());
            return (T) handleMethod.invoke(handlerInstanceBuilder, req);
        }
    }

}
