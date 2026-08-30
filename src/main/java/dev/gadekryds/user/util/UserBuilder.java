package dev.gadekryds.user.util;


import dev.gadekryds.common.eventsourcing.EntityBuilder;
import dev.gadekryds.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBuilder extends EntityBuilder<User, UserEvent> {

    public UserBuilder(List<UserEventApplier<?>> appliers) {
        super(User::new, appliers);
    }
}