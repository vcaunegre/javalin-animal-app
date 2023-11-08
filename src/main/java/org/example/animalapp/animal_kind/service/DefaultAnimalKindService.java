package org.example.animalapp.animal_kind.service;

import jakarta.inject.Inject;
import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.dto.KindResponse;
import org.example.animalapp.animal_kind.repository.AnimalKindRepository;

import java.util.List;

public class DefaultAnimalKindService implements AnimalKindService{

    final AnimalKindRepository animalKindRepository;

    @Inject
    public DefaultAnimalKindService(AnimalKindRepository animalKindRepository) {
        this.animalKindRepository = animalKindRepository;
    }

    @Override
    public List<KindResponse> getAllKinds() {
        return animalKindRepository.getAllKinds();
    }

    @Override
    public void addKind(CreateKind ck) {
animalKindRepository.createNewKind(ck);
    }

    @Override
    public void deleteKind(Long id) {
        animalKindRepository.deleteById(id);
    }

    @Override
    public void editKind(EditKind ek) {
        animalKindRepository.editKind(ek);
    }
}
