package org.example.animalapp.animal_race.service;

import com.google.inject.AbstractModule;

public class AnimalRaceServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalRaceService.class).to(DefaultAnimalRaceService.class);
    }
}
