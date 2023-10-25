package org.example.animalapp.animal_kind;

import com.google.inject.AbstractModule;
import org.example.animalapp.animal.AnimalController;
import org.example.animalapp.animal.repository.AnimalRepositoryModule;
import org.example.animalapp.animal.service.AnimalServiceModule;
import org.example.animalapp.animal_kind.repository.AnimalKindRepositoryModule;
import org.example.animalapp.animal_kind.service.AnimalKindService;
import org.example.animalapp.animal_kind.service.AnimalKindServiceModule;

public class AnimalKindModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AnimalKindController.class);
        install(new AnimalKindServiceModule());
        install(new AnimalKindRepositoryModule());
    }
}
