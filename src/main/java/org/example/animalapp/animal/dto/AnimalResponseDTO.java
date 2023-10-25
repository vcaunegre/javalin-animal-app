package org.example.animalapp.animal.dto;

import org.example.animalapp.animal.entities.Animal;
import org.example.animalapp.animal.entities.Owner;

public record AnimalResponseDTO(Long id, String name, OwnerResponseDTO owner, AnimalKindResponseDTO kind, AnimalRaceResponseDTO race) {
}

record OwnerResponseDTO(Long id, String name) {
    public OwnerResponseDTO(Owner o) {
        this(o.getId(), o.getName());
    }
}

record AnimalRaceResponseDTO(Long id, String name){}

record AnimalKindResponseDTO(Long id, String name){}