package org.example.animalapp.animal_race;

import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;
import org.example.animalapp.animal_race.service.AnimalRaceService;

public class AnimalRaceController {

    private AnimalRaceService animalRaceService;



    @Inject
    public AnimalRaceController(AnimalRaceService animalRaceService) {
        this.animalRaceService = animalRaceService;
    }


    public void getAllRaceForKind(Context ctx){
        ctx.json(animalRaceService.getAllRaceForKind(ctx.pathParamAsClass("id", Long.class).get()));
    }

    public void addRace(Context ctx){
        animalRaceService.addRace(ctx.bodyAsClass(RaceDTO.class));
    }

    public void deleteRace(Context ctx){
        animalRaceService.deleteRace(ctx.pathParamAsClass("id", Long.class).get());
    }

    public void editRace(Context ctx){
        animalRaceService.editRace(ctx.bodyAsClass(RaceEditDTO.class));
    }

}
