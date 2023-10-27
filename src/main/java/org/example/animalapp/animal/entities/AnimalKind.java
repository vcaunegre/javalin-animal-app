package org.example.animalapp.animal.entities;

import java.util.List;

public class AnimalKind {

    private Long id;
    private String name;
    private float avgLifeExpectancy;

    private List<AnimalRace> races;

    public List<AnimalRace> getRaces() {
        return races;
    }

    public AnimalKind setRaces(List<AnimalRace> races) {
        this.races = races;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalKind setName(String name) {
        this.name = name;
        return this;
    }

    public float getAvgLifeExpectancy() {
        return avgLifeExpectancy;
    }

    public AnimalKind setAvgLifeExpectancy(float avgLifeExpectancy) {
        this.avgLifeExpectancy = avgLifeExpectancy;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AnimalKind setId(Long id) {
        this.id = id;
        return this;
    }
}
