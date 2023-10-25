package org.example.animalapp.animal_kind;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import jakarta.inject.Inject;
import org.example.config.Routing;

public class AnimalKindRouting extends Routing<AnimalKindController> {

    private Javalin javalin;

    @Inject
    public AnimalKindRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(()->{
            ApiBuilder.path("/api/animals-kind",()->{

            });
        });
    }
}
