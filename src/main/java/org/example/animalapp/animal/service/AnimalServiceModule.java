package org.example.animalapp.animal.service;

import com.google.inject.AbstractModule;

public class AnimalServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalService.class).to(DefaultAnimalService.class);
    }
}
