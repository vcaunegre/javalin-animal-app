package org.example.animalapp;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal.AnimalModule;
import org.example.animalapp.animal_kind.AnimalKindModule;

public class AnimalAppModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new AnimalModule());
        install(new AnimalKindModule());
        install(WebModule.create());
    }
}
