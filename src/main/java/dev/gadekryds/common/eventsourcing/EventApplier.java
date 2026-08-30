package dev.gadekryds.common.eventsourcing;


public interface EventApplier<T, E extends Event<T>> {
    void apply(T target, E event);
    //Class<E> eventType();
    @SuppressWarnings("unchecked")
    default Class<E> eventType() {
        return (Class<E>) getClass();
    }
}

