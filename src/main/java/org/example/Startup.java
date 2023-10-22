package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.config.AppEntrypoint;
import org.example.config.EntrypointType;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Singleton
public class Startup {
    @Inject(optional = true)
    private Map<EntrypointType, AppEntrypoint> entrypoints = Collections.emptyMap();

    public void boot(EntrypointType entrypointType, String[] args) {
        var entryPoint = Optional.ofNullable(entrypoints.get(entrypointType));
        entryPoint.orElseThrow(() -> new RuntimeException("Entrypoint not defined")).boot(args);
    }
}