package dev.gadekryds.common;

public interface Mediator {
    public <T> Response<T> request(Request<T> request);
    public Response<Void> notify(Notification notification);
}
