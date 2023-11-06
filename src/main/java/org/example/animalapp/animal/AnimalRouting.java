package org.example.animalapp.animal;

import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.example.config.Routing;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AnimalRouting extends Routing<AnimalController> {
    private Javalin javalin;

    @Inject
    public AnimalRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(() -> {
            path("/",()->{
                get(ctx->ctx.json("Hello from API"));
            });
            path("api/animals", () -> {
                get(ctx -> getController().index(ctx));
                path("/{id}",()->{
                    get(ctx->getController().getAnimalById(ctx));
                });
                post(ctx->getController().addAnimal(ctx));
                put(ctx->getController().editAnimal(ctx));
                path("delete-by-id/{id}", () -> {
                    delete(ctx -> getController().deleteById(ctx));
                });
                path("delete-by-name",()->{
                    delete(ctx->getController().deleteByName(ctx));
                });
            });
        });
    }
}
