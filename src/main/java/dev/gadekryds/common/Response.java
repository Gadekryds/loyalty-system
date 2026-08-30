package dev.gadekryds.common;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class Response<T> {
    public T data;
    public Exception exception;
    public boolean hasException() {
        return exception != null;
    }
}
