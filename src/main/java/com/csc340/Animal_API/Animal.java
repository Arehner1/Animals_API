package com.csc340.Animal_API;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")  // Optional: Specifies the table name in the database
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the primary key
    @Column(name = "animal_id")
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    // Getters and Setters
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}