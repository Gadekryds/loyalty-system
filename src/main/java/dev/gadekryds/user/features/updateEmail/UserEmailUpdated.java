package dev.gadekryds.user.features.updateEmail;

import dev.gadekryds.user.util.UserEvent;

import java.util.UUID;

public record UserEmailUpdated(UUID id, String email) implements UserEvent {
}
