package org.example.animalapp.animal.dto;

import org.example.animalapp.animal.entities.Owner;

public record OwnerResponseDTO(Long id, String name) {
    public OwnerResponseDTO(Owner o) {
        this(o.getId(), o.getName());
    }
}
