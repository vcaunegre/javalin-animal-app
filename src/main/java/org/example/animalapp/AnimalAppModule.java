package org.example.animalapp;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal.AnimalModule;

public class AnimalAppModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new AnimalModule());
        install(WebModule.create());
    }
}
