package org.example.animalapp.animal;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.animalapp.animal.repository.AnimalRepository;
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

//    public static void routes(Javalin app) {
//        AnimalRepository animalRepository = new AnimalRepository();
//        app.get("/", ctx -> {
//            var animals = animalRepository.getAllAnimals();
//            ctx.json(animals);
//        });
//
//        app.post("/", ctx -> {
//            Animal animal = ctx.bodyAsClass(Animal.class);
//            animal = animalRepository.addAnimal(animal);
//            ctx.json(animal);
//        });
//
//        app.delete("/delete/{id}", ctx -> {
//            Long id = ctx.pathParamAsClass("id", Long.class).get();
//            animalRepository.deleteAnimal(id);
//            ctx.status(HttpStatus.OK);
//        });
//
//        app.delete(("/delete-by-name"),ctx->{
//            var name=ctx.queryParamAsClass("name",String.class).get();
//            animalRepository.deleteByName(name);
//        });
//    }
}
