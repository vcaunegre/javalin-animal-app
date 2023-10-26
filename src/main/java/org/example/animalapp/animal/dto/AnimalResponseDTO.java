package org.example.animalapp.animal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.animalapp.animal.entities.Animal;
import org.example.animalapp.animal.entities.Owner;

import java.time.LocalDate;

public record AnimalResponseDTO(Long id, String name, @JsonFormat(pattern="yyyy-MM-dd") LocalDate dateOfBirth, OwnerResponseDTO owner, AnimalKindResponseDTO kind, AnimalRaceResponseDTO race) {
}

