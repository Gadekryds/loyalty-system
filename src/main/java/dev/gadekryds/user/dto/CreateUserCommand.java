package dev.gadekryds.user.dto;

public record CreateUserCommand(String firstName, String lastName, String email) {
}
