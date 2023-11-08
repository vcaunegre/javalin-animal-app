package org.example.animalapp.animal_race.service;

import org.example.animalapp.animal_race.dto.GetRaceDTO;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;

import java.util.List;

public interface AnimalRaceService {
    List<GetRaceDTO> getAllRaceForKind(Long kindId);

    void addRace(RaceDTO ck);

    void deleteRace(Long id);

    void editRace(RaceEditDTO ek);
}
