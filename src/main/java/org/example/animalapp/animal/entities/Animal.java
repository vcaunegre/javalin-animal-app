package org.example.animalapp.animal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "date_of_birth",nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_kind_id")
    private AnimalKind animalKind;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_race_id")
    private AnimalRace animalRace;

   @OneToOne(mappedBy = "animal")
   @JoinColumn(name = "owner_id")
   private Owner owner;

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
