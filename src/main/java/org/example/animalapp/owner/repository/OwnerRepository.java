package org.example.animalapp.owner.repository;

import org.example.animalapp.owner.dto.EditOwnerDto;
import org.example.animalapp.owner.dto.OwnerDto;

import java.util.List;

public interface OwnerRepository {
    List<OwnerDto> getOwners();
    void editOwner(EditOwnerDto ownerName);
}
