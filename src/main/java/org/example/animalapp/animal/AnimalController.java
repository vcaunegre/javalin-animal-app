package org.example.animalapp.animal;

import com.google.inject.Singleton;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.example.animalapp.animal.dto.CreateAnimalDto;
import org.example.animalapp.animal.dto.EditAnimalDto;
import org.example.animalapp.animal.entities.Animal;
import org.example.animalapp.animal.service.AnimalService;

@Singleton
public class AnimalController {
   private AnimalService animalService;

   @Inject
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void index(Context ctx){
    ctx.json(animalService.getAllAnimals());
}

public void deleteById(Context ctx){
       animalService.deleteById(ctx.pathParamAsClass("id",Long.class).get());
}

public void deleteByName(Context ctx){
       animalService.deleteByName(ctx.queryParamAsClass("name",String.class).get());
}
public void addAnimal(Context ctx){
    animalService.createAnimal(ctx.bodyAsClass(CreateAnimalDto.class));
}

public void editAnimal(Context ctx){animalService.editAnimal(ctx.bodyAsClass(EditAnimalDto.class));}
}

