package dev.gadekryds.common;

public interface NotificationHandler<T> {

    public void handle(T notification);
}
