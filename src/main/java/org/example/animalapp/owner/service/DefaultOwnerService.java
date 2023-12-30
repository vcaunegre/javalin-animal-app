package org.example.animalapp.owner.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.animalapp.owner.dto.EditOwnerDto;
import org.example.animalapp.owner.dto.OwnerDto;
import org.example.animalapp.owner.repository.OwnerRepository;

import java.util.List;

@Singleton
public class DefaultOwnerService implements OwnerService{
    private final OwnerRepository ownerRepository;

    @Inject
    public DefaultOwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerDto> getOwners() {
        return ownerRepository.getOwners();
    }

    @Override
    public void editOwner(EditOwnerDto editOwnerDto) {
        ownerRepository.editOwner(editOwnerDto);
    }
}
