package dev.gadekryds;

import dev.gadekryds.product.features.createProduct.ProductCreatedEvent;
import dev.gadekryds.product.util.ProductBuilder;
import dev.gadekryds.user.features.createUser.UserCreated;
import dev.gadekryds.user.features.updateEmail.UserEmailUpdated;
import dev.gadekryds.user.features.updateLastName.UserLastNameUpdated;
import dev.gadekryds.user.util.UserBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StartupRunner implements CommandLineRunner {
    private final ApplicationEventPublisher publisher;
    private final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    private UserBuilder userBuilder;
    @Autowired
    private ProductBuilder productBuilder;
    public StartupRunner(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) {
        UUID uuid = UUID.randomUUID();
        var user = userBuilder.build(List.of(
                new UserCreated(uuid, "Jeppe", "Sørensen", ""),
                new UserLastNameUpdated(uuid, "Dockweiler"),
                new UserEmailUpdated(uuid, "jsdockwiler@gmail.com")
        ));

        UUID uuid2 = UUID.randomUUID();

        var product = productBuilder.build(List.of(
                new ProductCreatedEvent(uuid2, "Disco ball")
        ));
    }
}
