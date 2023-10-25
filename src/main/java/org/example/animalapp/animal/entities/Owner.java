package org.example.animalapp.animal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonIgnore
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
