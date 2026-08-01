package dev.gadekryds.common;

public interface Handler<T, E extends Action<T>>  {

    T Handle(E req);

}
