package org.example.animalapp.animal.repository;

import org.example.animalapp.animal.entities.Animal;

import java.util.List;

public interface AnimalRepository {
    List<Animal> getAllAnimals();

    Animal addAnimal(Animal animal);

    void deleteAnimal(long animalId);

    void deleteByName(String name);
}
