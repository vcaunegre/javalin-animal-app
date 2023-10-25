package org.example.animalapp.animal_kind;

import jakarta.inject.Inject;
import org.example.animalapp.animal_kind.service.AnimalKindService;

public class AnimalKindController {

    private AnimalKindService animalKindService;

    @Inject
    public AnimalKindController(AnimalKindService animalKindService) {
        this.animalKindService = animalKindService;
    }
}
