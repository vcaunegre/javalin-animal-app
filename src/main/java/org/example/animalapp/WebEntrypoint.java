package org.example.animalapp;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.Javalin;
import org.example.config.AppEntrypoint;
import org.example.config.Routing;

import java.util.Collections;
import java.util.Set;

@Singleton
class WebEntrypoint implements AppEntrypoint {
    private Javalin app;

    @Inject(optional = true)
    private Set<Routing> routes = Collections.emptySet();

    @Inject
    public WebEntrypoint(Javalin app) {
        this.app = app;
    }

    @Override
    public void boot(String[] args) {
        bindRoutes();
        app.start(7070);
    }

    private void bindRoutes() {
        routes.forEach(r -> r.bindRoutes());
    }
}