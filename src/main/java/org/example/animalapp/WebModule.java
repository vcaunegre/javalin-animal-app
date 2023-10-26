package org.example.animalapp;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import org.example.config.AppEntrypoint;
import org.example.config.EntrypointType;
import org.jetbrains.annotations.NotNull;

public class WebModule extends AbstractModule {
    private Javalin app;

    public WebModule(Javalin app) {
        this.app = app;
    }

    @NotNull
    public static WebModule create() {
        return new WebModule(Javalin.create(config->{
            config.plugins.enableCors(cors -> {
                cors.add(CorsPluginConfig::anyHost);
            });
        }));
    }

    @Override
    protected void configure() {
        bind(Javalin.class).toInstance(app);
        MapBinder.newMapBinder(binder(), EntrypointType.class, AppEntrypoint.class).addBinding(EntrypointType.REST).to(WebEntrypoint.class);
    }
}
