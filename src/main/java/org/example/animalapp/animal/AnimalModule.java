package org.example.animalapp.animal;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.example.animalapp.animal.repository.AnimalRepositoryModule;
import org.example.animalapp.animal.service.AnimalServiceModule;
import org.example.config.Routing;

public class AnimalModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalController.class);
        install(new AnimalServiceModule());
        install(new AnimalRepositoryModule());
        Multibinder.newSetBinder(binder(), Routing.class).addBinding().to(AnimalRouting.class);
    }
}
