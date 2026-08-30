package dev.gadekryds.user.util;

import dev.gadekryds.common.eventsourcing.Event;
import dev.gadekryds.user.User;

import java.util.UUID;

public interface UserEvent extends Event<User> {
    UUID id();
}
