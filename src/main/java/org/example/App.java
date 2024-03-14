package org.example;

import com.google.inject.Guice;
import org.example.animalapp.Utils;
import org.example.config.EntrypointType;

public class App {

    public static void main(String[] args) {
        System.out.println("Max Heap Size = " + Runtime.getRuntime().maxMemory());

        Utils.flywayConfig();
        var injector = Guice.createInjector(new AppModule());
        injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
    }
}
