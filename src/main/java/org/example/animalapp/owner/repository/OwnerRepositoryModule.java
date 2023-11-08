package org.example.animalapp.owner.repository;

import com.google.inject.AbstractModule;

public class OwnerRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OwnerRepository.class).to(DefaultOwnerRepository.class);
    }
}
