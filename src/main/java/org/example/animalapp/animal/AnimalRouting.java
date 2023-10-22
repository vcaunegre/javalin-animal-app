package org.example.animalapp.animal;

import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.example.config.Routing;

public class AnimalRouting extends Routing<AnimalController> {
    private Javalin javalin;

    @Inject
    public AnimalRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(() -> {
            ApiBuilder.path("api/animals", () -> {
                ApiBuilder.get(ctx -> getController().index(ctx));
            });
        });
    }
}
