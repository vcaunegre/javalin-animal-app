package org.example.animalapp.owner;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.example.animalapp.owner.repository.OwnerRepositoryModule;
import org.example.animalapp.owner.service.OwnerServiceModule;
import org.example.config.Routing;

public class OwnerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OwnerController.class);
        install(new OwnerServiceModule());
        install(new OwnerRepositoryModule());
        Multibinder.newSetBinder(binder(), Routing.class).addBinding().to(OwnerRouting.class);
    }
}
