package org.example.animalapp.animal.entities;

public class Owner {

    Long id;

    private String name;

    private Animal animal;

    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Owner setId(Long id) {
        this.id = id;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Owner setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }
}
