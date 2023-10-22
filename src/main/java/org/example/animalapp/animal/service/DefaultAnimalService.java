package org.example.animalapp.animal.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.animalapp.animal.entities.Animal;
import org.example.animalapp.animal.repository.AnimalRepository;

import java.util.List;

@Singleton
public class DefaultAnimalService implements AnimalService {

    private AnimalRepository animalRepository;

    @Inject
    public DefaultAnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }
}
