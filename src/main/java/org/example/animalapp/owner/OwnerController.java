package org.example.animalapp.owner;

import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.example.animalapp.owner.dto.EditOwnerDto;
import org.example.animalapp.owner.service.OwnerService;

public class OwnerController {

    final OwnerService ownerService;

    @Inject
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    void getOwners(Context ctx){
        ctx.json(ownerService.getOwners());
    }

    void editOwners(Context ctx){
        ownerService.editOwner(ctx.bodyAsClass(EditOwnerDto.class));
    }
}
