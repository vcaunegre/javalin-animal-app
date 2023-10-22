package org.example.animalapp.animal.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.App;
import org.example.animalapp.animal.entities.AnimalKind;
import org.example.animalapp.animal.entities.Owner;
import org.example.animalapp.animal.persistence.CustomPersistenceUnitInfo;
import org.example.animalapp.animal.entities.Animal;
import org.example.animalapp.animal.entities.AnimalRace;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultAnimalRepository implements AnimalRepository {
    String puName = "pu-name";
    Map<String, String> props = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(App.class);

    private EntityManager initSession() {
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update"); // create, none, update
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
        return emf.createEntityManager();
    }

    private void init(EntityManager em) {
        em.getTransaction().begin();
        AnimalRace pitbull = new AnimalRace().setName("Pitbull");
        AnimalRace chihuahua = new AnimalRace().setName("Chihuahua");
        AnimalKind dog = new AnimalKind().setName("Dog").setAvgLifeExpectancy(12).setRaces(List.of(pitbull, chihuahua));
        pitbull.setAnimalKind(dog);
        chihuahua.setAnimalKind(dog);
        Owner owner = new Owner().setName("John Doe");
        Animal bobby = new Animal().setName("Bobby").setOwner(owner).setAnimalKind(dog).setAnimalRace(chihuahua).setDateOfBirth(LocalDate.of(2022, 12, 12));
        owner.setAnimal(bobby);
        em.persist(owner);
        em.getTransaction().commit(); // end of transaction
    }

    public List<Animal> getAllAnimals() {
        try (EntityManager em = initSession()) {
            init(em);
            List<Animal> result = new ArrayList<>();
            em.getTransaction().begin();
            result = em.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
            em.getTransaction().commit(); // end of transaction
            return result;
        }
    }

    public Animal addAnimal(Animal animal) {
        try (EntityManager em = initSession()) {
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
            return animal;
        }
    }

    public void deleteById(long animalId) {
        try (EntityManager em = initSession()) {
            em.getTransaction().begin();
            Animal animal = em.find(Animal.class, animalId);
            if (animal != null) {
                em.remove(animal.getOwner());
                em.remove(animal);
            }
            em.getTransaction().commit();
        }
    }

    public void deleteByName(String name) {
        try (EntityManager em = initSession()) {
            em.getTransaction().begin();
            Query qAnimal = em.createQuery("DELETE FROM Animal a WHERE a.name = :name");
            qAnimal.setParameter("name",name);
            qAnimal.executeUpdate();
            em.getTransaction().commit();
        }
    }
}
