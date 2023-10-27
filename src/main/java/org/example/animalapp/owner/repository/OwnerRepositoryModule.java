package org.example.animalapp.owner.repository;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal_race.repository.AnimalRaceRepository;
import org.example.animalapp.animal_race.repository.DefaultAnimalRaceRepository;

public class OwnerRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OwnerRepository.class).to(DefaultOwnerRepository.class);
    }
}
