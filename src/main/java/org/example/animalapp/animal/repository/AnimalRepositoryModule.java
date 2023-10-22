package org.example.animalapp.animal.repository;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal.service.AnimalService;
import org.example.animalapp.animal.service.DefaultAnimalService;

public class AnimalRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalRepository.class).to(DefaultAnimalRepository.class);
    }
}
