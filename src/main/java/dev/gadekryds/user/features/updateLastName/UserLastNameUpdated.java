package dev.gadekryds.user.features.updateLastName;

import dev.gadekryds.user.util.UserEvent;

import java.util.UUID;

public record UserLastNameUpdated(UUID id, String lastName) implements UserEvent {
}
