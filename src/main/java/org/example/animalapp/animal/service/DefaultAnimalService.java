package org.example.animalapp.animal.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.animalapp.animal.dto.AnimalResponseDTO;
import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.dto.EditAnimalDto;
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
    public List<AnimalResponseDTO> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }

    @Override
    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public void createAnimal(CreateAnimalDto createAnimalDto) {
         animalRepository.createNewAnimal(createAnimalDto);
    }

    @Override
    public void deleteByName(String name) {
        animalRepository.deleteByName(name);
    }

    @Override
    public void editAnimal(EditAnimalDto animalDto) {
        animalRepository.editAnimal(animalDto);
    }
}
