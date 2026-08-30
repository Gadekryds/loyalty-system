package dev.gadekryds.user.util;

import dev.gadekryds.common.eventsourcing.EventApplier;
import dev.gadekryds.user.User;

public interface UserEventApplier<T extends  UserEvent> extends EventApplier<User, T> {
}
