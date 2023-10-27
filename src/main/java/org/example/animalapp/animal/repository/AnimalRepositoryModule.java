package org.example.animalapp.animal.repository;

import com.google.inject.AbstractModule;
public class AnimalRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalRepository.class).to(DefaultAnimalRepository.class);
    }
}
