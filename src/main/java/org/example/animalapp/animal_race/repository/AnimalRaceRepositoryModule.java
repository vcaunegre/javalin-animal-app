package org.example.animalapp.animal_race.repository;

import com.google.inject.AbstractModule;

public class AnimalRaceRepositoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AnimalRaceRepository.class).to(DefaultAnimalRaceRepository.class);
    }
}
