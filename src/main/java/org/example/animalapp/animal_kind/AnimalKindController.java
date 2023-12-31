package org.example.animalapp.animal_kind;

import io.javalin.http.Context;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.service.AnimalKindService;

@Singleton
public class AnimalKindController {

    private final AnimalKindService animalKindService;

    @Inject
    public AnimalKindController(AnimalKindService animalKindService) {
        this.animalKindService = animalKindService;
    }

    public void getAllKinds(Context ctx) {
        ctx.json(animalKindService.getAllKinds());
    }

    public void addKind(Context ctx) {
        animalKindService.addKind(ctx.bodyAsClass(CreateKind.class));
    }

    public void deleteKind(Context ctx) {
        animalKindService.deleteKind(ctx.pathParamAsClass("id", Long.class).get());
    }

    public void editKind(Context ctx) {
        animalKindService.editKind(ctx.bodyAsClass(EditKind.class));
    }

}
