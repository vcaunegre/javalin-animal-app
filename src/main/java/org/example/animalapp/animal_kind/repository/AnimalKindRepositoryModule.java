package org.example.animalapp.animal_kind.repository;

import com.google.inject.AbstractModule;

public class AnimalKindRepositoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AnimalKindRepository.class).to(DefaultAnimalKindRepository.class);
    }
}
