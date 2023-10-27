package org.example.animalapp.owner.service;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal_race.repository.AnimalRaceRepository;
import org.example.animalapp.animal_race.repository.DefaultAnimalRaceRepository;

public class OwnerServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OwnerService.class).to(DefaultOwnerService.class);
    }
}
