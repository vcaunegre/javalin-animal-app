package org.example.animalapp.animal.service;

import org.example.animalapp.animal.dto.AnimalResponseDTO;
import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.dto.EditAnimalDto;
import org.example.animalapp.animal.entities.Animal;

import java.util.List;

public interface AnimalService {
    List<AnimalResponseDTO> getAllAnimals();

    void deleteById(Long id);

    void createAnimal(CreateAnimalDto createAnimalDto);

    void deleteByName(String name);

    void editAnimal(EditAnimalDto animalDto);
}
