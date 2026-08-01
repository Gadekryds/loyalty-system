package dev.gadekryds.user.features.updateLastName;

import dev.gadekryds.user.User;
import dev.gadekryds.user.util.UserEventApplier;
import org.springframework.stereotype.Component;

@Component
public class UserLastNameUpdatedApplier implements UserEventApplier<UserLastNameUpdated> {
    @Override
    public void apply(User user, UserLastNameUpdated event) {
        user.setLastName(event.lastName());
    }

    @Override
    public Class<UserLastNameUpdated> eventType() {
        return UserLastNameUpdated.class;
    }
}
