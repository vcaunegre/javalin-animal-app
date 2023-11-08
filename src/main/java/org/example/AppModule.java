package org.example;

import com.google.inject.AbstractModule;
import org.example.animalapp.AnimalAppModule;

public class AppModule extends AbstractModule {
    protected void configure() {
        bind(Startup.class);
        install(new AnimalAppModule());
    }
}
