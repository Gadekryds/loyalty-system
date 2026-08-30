package dev.gadekryds.common;

public interface RequestHandler<T, E>  {

    T Handle(E req);
}
