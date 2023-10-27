package org.example.animalapp;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal.AnimalModule;
import org.example.animalapp.animal_kind.AnimalKindModule;
import org.example.animalapp.animal_race.AnimalRaceModule;
import org.example.animalapp.owner.OwnerModule;

public class AnimalAppModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new AnimalModule());
        install(new AnimalKindModule());
        install(new OwnerModule());
        install(new AnimalRaceModule());
        install(WebModule.create());
    }
}
