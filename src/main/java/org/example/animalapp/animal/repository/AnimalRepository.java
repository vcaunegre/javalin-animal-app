package org.example.animalapp.animal.repository;

import org.example.animalapp.animal.dto.AnimalResponseDTO;
import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.dto.EditAnimalDto;
import org.example.animalapp.animal.entities.Animal;

import java.util.List;

public interface AnimalRepository {
    List<AnimalResponseDTO> getAllAnimals();

    void deleteById(long animalId);

    void deleteByName(String name);

    void createNewAnimal(CreateAnimalDto nAnimal);

    void editAnimal(EditAnimalDto animal);
}
