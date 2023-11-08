package org.example.animalapp.animal_kind.service;

import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.dto.KindResponse;

import java.util.List;

public interface AnimalKindService {
    List<KindResponse> getAllKinds();

    void addKind(CreateKind ck);

    void deleteKind(Long id);

    void editKind(EditKind ek);
}
