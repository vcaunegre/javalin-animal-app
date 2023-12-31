package org.example.animalapp.animal_kind;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.config.Routing;

import static io.javalin.apibuilder.ApiBuilder.*;

@Singleton
public class AnimalKindRouting extends Routing<AnimalKindController> {

    private final Javalin javalin;

    @Inject
    public AnimalKindRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(() -> ApiBuilder.path("/api/animal-kinds", () -> {
            get(ctx -> getController().getAllKinds(ctx));
            post(ctx -> getController().addKind(ctx));
            put(ctx -> getController().editKind(ctx));
            path("/{id}", () -> delete(ctx -> getController().deleteKind(ctx)));
        }));
    }
}
