package org.example.animalapp.animal_race.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.animalapp.animal_race.dto.GetRaceDTO;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;
import org.example.animalapp.animal_race.repository.AnimalRaceRepository;

import java.util.List;

@Singleton
public class DefaultAnimalRaceService implements AnimalRaceService {

    final AnimalRaceRepository animalRaceRepository;

    @Inject
    public DefaultAnimalRaceService(AnimalRaceRepository animalRaceRepository) {
        this.animalRaceRepository = animalRaceRepository;
    }

    @Override
    public List<GetRaceDTO> getAllRaceForKind(Long kindId) {
        return animalRaceRepository.getAllRacesForAKind(kindId);
    }

    @Override
    public void addRace(RaceDTO ck) {
        animalRaceRepository.createNewRace(ck);
    }

    @Override
    public void deleteRace(Long id) {
        animalRaceRepository.deleteById(id);
    }

    @Override
    public void editRace(RaceEditDTO ek) {
        animalRaceRepository.editRace(ek);
    }
}
