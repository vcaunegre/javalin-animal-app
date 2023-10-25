package org.example.animalapp.animal.service;

import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.entities.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();

    void deleteById(Long id);

    Animal createAnimal(CreateAnimalDto createAnimalDto);
}
