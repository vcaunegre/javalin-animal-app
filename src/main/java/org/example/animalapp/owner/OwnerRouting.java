package org.example.animalapp.owner;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.config.Routing;

import static io.javalin.apibuilder.ApiBuilder.*;

@Singleton
public class OwnerRouting extends Routing<OwnerController> {

    private final Javalin javalin;

    @Inject
    public OwnerRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(()-> ApiBuilder.path("/api/owners",()->{
            get(ctx->getController().getOwners(ctx));
            put(ctx->getController().editOwners(ctx));
            }));
    }
}