package org.example.animalapp.animal_race;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.config.Routing;

import static io.javalin.apibuilder.ApiBuilder.*;

@Singleton
public class AnimalRaceRouting extends Routing<AnimalRaceController> {

    private final Javalin javalin;

    @Inject
    public AnimalRaceRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(() -> ApiBuilder.path("/api/animal-races", () -> {
            path("/{id}", () -> {
                get(ctx -> getController().getAllRaceForKind(ctx));
                delete(ctx -> getController().deleteRace(ctx));
            });
            post(ctx -> getController().addRace(ctx));
            put(ctx -> getController().editRace(ctx));
        }));
    }
}
