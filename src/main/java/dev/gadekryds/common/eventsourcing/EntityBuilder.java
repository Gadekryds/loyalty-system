package dev.gadekryds.common.eventsourcing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public abstract class EntityBuilder<T, E extends Event<T>> {

    private final Map<Class<? extends Event<T>>, EventApplier<T, ?>> appliers;
    private final Supplier<T> supplier;

    protected EntityBuilder(
            Supplier<T> supplier,
            List<? extends EventApplier<T, ?>> appliers) {

        this.supplier = supplier;
        this.appliers = new HashMap<>();

        for (EventApplier<T, ?> applier : appliers) {
            this.appliers.put(applier.eventType(), applier);
        }
    }

    public T build(List<E> events) {
        T entity = supplier.get();
        for (E event : events) {
            applyEvent(entity, event);
        }

        return entity;
    }

    @SuppressWarnings("unchecked")
    private <E extends Event<T>> void applyEvent(T entity, E event) {
        var applier = (EventApplier<T, E>) appliers.get(event.getClass());
        applier.apply(entity, event);
    }
}
