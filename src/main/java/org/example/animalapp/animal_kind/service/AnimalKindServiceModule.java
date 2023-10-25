package org.example.animalapp.animal_kind.service;

import com.google.inject.AbstractModule;

public class AnimalKindServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalKindService.class).to(DefaultAnimalKindService.class);
    }
}
