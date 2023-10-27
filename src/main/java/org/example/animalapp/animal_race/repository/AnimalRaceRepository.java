package org.example.animalapp.animal_race.repository;

import org.example.animalapp.animal_race.dto.GetRaceDTO;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;

import java.util.List;

public interface AnimalRaceRepository {
    List<GetRaceDTO> getAllRacesForAKind(Long kindId);

    void deleteById(long raceId);

    void createNewRace(RaceDTO nRace);

    void editRace(RaceEditDTO eRace);
}
