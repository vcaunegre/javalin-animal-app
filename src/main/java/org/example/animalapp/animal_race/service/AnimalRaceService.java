package org.example.animalapp.animal_race.service;

import org.example.animalapp.animal_race.dto.GetRaceDTO;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;

import java.util.List;

public interface AnimalRaceService {
    public List<GetRaceDTO> getAllRaceForKind(Long kindId);

    public void addRace(RaceDTO ck);

    public void deleteRace(Long id);

    public void editRace(RaceEditDTO ek);
}
