package dev.gadekryds.user.features.createUser;

import dev.gadekryds.user.util.UserEvent;

import java.util.UUID;

public record UserCreated(UUID id, String firstName, String lastName, String email) implements UserEvent {
}
