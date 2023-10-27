package org.example.animalapp.animal_race;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.example.animalapp.animal_race.repository.AnimalRaceRepositoryModule;
import org.example.animalapp.animal_race.service.AnimalRaceServiceModule;
import org.example.config.Routing;

public class AnimalRaceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AnimalRaceController.class);
        install(new AnimalRaceServiceModule());
        install(new AnimalRaceRepositoryModule());
        Multibinder.newSetBinder(binder(), Routing.class).addBinding().to(AnimalRaceRouting.class);

    }
}
