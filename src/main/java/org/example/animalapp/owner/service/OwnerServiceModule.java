package org.example.animalapp.owner.service;

import com.google.inject.AbstractModule;

public class OwnerServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OwnerService.class).to(DefaultOwnerService.class);
    }
}
