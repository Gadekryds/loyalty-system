package dev.gadekryds.user.features.createUser;

import dev.gadekryds.user.User;
import dev.gadekryds.user.util.UserEventApplier;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedApplier implements UserEventApplier<UserCreated> {
    @Override
    public void apply(User user, UserCreated event) {
        user.setId(event.id());
        user.setFirstName(event.firstName());
        user.setLastName(event.lastName());
        user.setEmail(event.email());
    }

    @Override
    public Class<UserCreated> eventType() {
        return UserCreated.class;
    }
}
