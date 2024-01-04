package org.example;

import com.google.inject.Guice;
import org.example.animalapp.Utils;
import org.example.config.EntrypointType;
import org.flywaydb.core.Flyway;

public class App {

    public static void main(String[] args) {
        Flyway flyway=Flyway.configure().dataSource(Utils.PG_URL,Utils.PG_USER,Utils.PG_PASSWORD).load();
        flyway.baseline();
        flyway.migrate();
        var injector = Guice.createInjector(new AppModule());
        injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
    }
}
