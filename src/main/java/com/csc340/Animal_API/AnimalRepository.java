package com.csc340.Animal_API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // Find animals by their name
    List<Animal> getByName(String name);

    // Find animals with descriptions containing a specific word
    @Query("SELECT a FROM Animal a WHERE a.description LIKE %?1%")
    List<Animal> getAnimalsByDescription(String description);

    // Custom query to find animals by description length (just an example of how you can use native SQL)
    @Query(value = "SELECT * FROM animal a WHERE LENGTH(a.description) >= ?1", nativeQuery = true)
    List<Animal> getAnimalsByDescriptionLength(int length);


}