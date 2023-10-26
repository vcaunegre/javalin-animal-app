package org.example.animalapp.animal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Animal {

    private Long id;
    private String name;

    private LocalDate dateOfBirth;

    private AnimalKind animalKind;

    private AnimalRace animalRace;

   private Owner owner;

    public Animal() {
    }

    public Animal(Long id, String name, LocalDate dateOfBirth, AnimalKind animalKind, AnimalRace animalRace, Owner owner) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.animalKind = animalKind;
        this.animalRace = animalRace;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public Animal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalKind getAnimalKind() {
        return animalKind;
    }

    public Animal setAnimalKind(AnimalKind animalKind) {
        this.animalKind = animalKind;
        return this;
    }

    public AnimalRace getAnimalRace() {
        return animalRace;
    }

    public Animal setAnimalRace(AnimalRace animalRace) {
        this.animalRace = animalRace;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public Animal setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Animal setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
