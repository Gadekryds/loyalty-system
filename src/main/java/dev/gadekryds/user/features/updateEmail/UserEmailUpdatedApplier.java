package dev.gadekryds.user.features.updateEmail;

import dev.gadekryds.user.User;
import dev.gadekryds.user.util.UserEventApplier;
import org.springframework.stereotype.Component;

@Component
public class UserEmailUpdatedApplier implements UserEventApplier<UserEmailUpdated> {

    @Override
    public void apply(User target, UserEmailUpdated event) {
        target.setEmail(event.email());
    }

    @Override
    public Class<UserEmailUpdated> eventType() {
        return UserEmailUpdated.class;
    }
}
