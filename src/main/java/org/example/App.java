package org.example;

import com.google.inject.Guice;
import org.example.animalapp.Utils;
import org.example.config.EntrypointType;

public class App {

    public static void main(String[] args) {
        Utils.flywayConfig();
        var injector = Guice.createInjector(new AppModule());
        injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
    }
}
