package org.example.animalapp.owner.service;

import org.example.animalapp.owner.dto.EditOwnerDto;
import org.example.animalapp.owner.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    List<OwnerDto> getOwners();

    void editOwner(EditOwnerDto editOwnerDto);
}
