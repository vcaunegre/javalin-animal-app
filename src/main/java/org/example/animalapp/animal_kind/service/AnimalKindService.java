package org.example.animalapp.animal_kind.service;

import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.dto.KindResponse;

import java.util.List;

public interface AnimalKindService {
    public List<KindResponse> getAllKinds();

    public void addKind(CreateKind ck);

    public void deleteKind(Long id);

    public void editKind(EditKind ek);
}
