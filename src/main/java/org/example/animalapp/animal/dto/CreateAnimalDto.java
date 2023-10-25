package org.example.animalapp.animal.dto;

import java.time.LocalDate;

public record CreateAnimalDto(String name, LocalDate dateOfBirth,Long animalKindId, Long animalRaceId, Long ownerId) {
}
