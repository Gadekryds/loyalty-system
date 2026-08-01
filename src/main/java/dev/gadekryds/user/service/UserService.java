package dev.gadekryds.user.service;

import dev.gadekryds.user.dto.CreateUserCommand;
import dev.gadekryds.user.features.createUser.UserCreated;
import dev.gadekryds.user.util.UserBuilder;

import java.util.List;
import java.util.UUID;

public class UserService {

    private final UserBuilder userBuilder;

    public UserService(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    public void createUser(CreateUserCommand req) {

        var userId = UUID.randomUUID();

        var createUserEvent = new UserCreated(
                userId,
                req.firstName(),
                req.lastName(),
                req.email()
        );

        var user = userBuilder.build(List.of(createUserEvent));
        // Save ledger
        // Save projection
    }

}
