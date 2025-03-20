package com.csc340.Animal_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /**
     * Fetch a unique animal by its ID.
     *
     * @param animalId the unique animal ID.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose name matches the search term.
     *
     * @param name the search name.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.getByName(name);
    }

    /**
     * Fetch all animals with a description containing the given string.
     *
     * @param description the search description.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByDescription(String description) {
        return animalRepository.getAnimalsByDescription(description);
    }

    /**
     * Fetch all animals with a description length greater than or equal to the given length.
     *
     * @param length the minimum description length.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByDescriptionLength(int length) {
        return animalRepository.getAnimalsByDescriptionLength(length);
    }

    /**
     * Add a new animal to the database.
     *
     * @param animal the new Animal to add.
     * @return the saved Animal.
     */
    public Animal addNewAnimal(Animal animal) {
        return animalRepository.save(animal);  // Save and return the created animal
    }

    /**
     * Update an existing animal.
     *
     * @param animalId the unique animal ID.
     * @param animal   the new animal details.
     */
    public Animal updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        if (existing != null) {
            existing.setName(animal.getName());
            existing.setDescription(animal.getDescription());

            // You can add any other fields you need to update, like breed, age, etc.
            return animalRepository.save(existing);
        }
        return null;
    }

    /**
     * Get all animals
     *
     * @return list of all animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Delete a unique animal by ID.
     *
     * @param animalId the unique animal ID.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
