package org.example.animalapp.animal.repository;

import org.example.animalapp.animal.dto.AnimalResponseDTO;
import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.dto.EditAnimalDto;
import org.example.animalapp.animal.entities.Animal;

import java.awt.print.Pageable;
import java.util.List;

public interface AnimalRepository {
    List<AnimalResponseDTO> getAllAnimals(int page, int size);

    AnimalResponseDTO getAnimalById(Long id);

    void deleteById(long animalId);

    void deleteByName(String name);

    void createNewAnimal(CreateAnimalDto nAnimal);

    void editAnimal(EditAnimalDto animal);
}
