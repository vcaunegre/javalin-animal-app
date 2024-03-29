package org.example.animalapp.animal_kind;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.example.animalapp.animal_kind.repository.AnimalKindRepositoryModule;
import org.example.animalapp.animal_kind.service.AnimalKindServiceModule;
import org.example.config.Routing;

public class AnimalKindModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AnimalKindController.class);
        install(new AnimalKindServiceModule());
        install(new AnimalKindRepositoryModule());
        Multibinder.newSetBinder(binder(), Routing.class).addBinding().to(AnimalKindRouting.class);

    }
}
