package org.example.animalapp.animal.dto;

import java.time.LocalDate;

public record EditAnimalDto(Long id,String name, LocalDate dateOfBirth, Long kindId,Long raceId) {
}
