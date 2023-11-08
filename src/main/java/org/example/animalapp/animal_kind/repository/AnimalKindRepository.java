package org.example.animalapp.animal_kind.repository;

import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.dto.KindResponse;

import java.util.List;

public interface AnimalKindRepository {
    List<KindResponse> getAllKinds();

    void deleteById(long kindId);

    void createNewKind(CreateKind cKind);

    void editKind(EditKind editKind);
}
