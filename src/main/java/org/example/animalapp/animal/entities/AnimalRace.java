package org.example.animalapp.animal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "animal_races")
public class AnimalRace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_kind_id")
    @JsonIgnore
    private AnimalKind animalKind;

    public String getName() {
        return name;
    }

    public AnimalRace setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AnimalRace setId(Long id) {
        this.id = id;
        return this;
    }

    public AnimalKind getAnimalKind() {
        return animalKind;
    }

    public AnimalRace setAnimalKind(AnimalKind animalKind) {
        this.animalKind = animalKind;
        return this;
    }
}
