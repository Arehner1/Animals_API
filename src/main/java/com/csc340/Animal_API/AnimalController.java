package com.csc340.Animal_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all endpoints for Animal object with FreeMarker templates and API endpoints.
 */
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    // JSON API Endpoints
    @GetMapping(value = "/api/all", produces = "application/json")
    @ResponseBody
    public List<Animal> getAllAnimalsJson() {
        return service.getAllAnimals();
    }

    @GetMapping(value = "/api/{animalId}", produces = "application/json")
    @ResponseBody
    public Animal getOneAnimalJson(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    @PostMapping(value = "/api/new", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Animal addNewAnimalJson(@RequestBody Animal animal) {
        return service.addNewAnimal(animal);
    }

    @PutMapping(value = "/api/update/{animalId}", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Animal updateAnimalJson(@PathVariable int animalId, @RequestBody Animal animal) {
        return service.updateAnimal(animalId, animal);
    }

    @DeleteMapping(value = "/api/delete/{animalId}", produces = "application/json")
    @ResponseBody
    public void deleteAnimalByIdJson(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
    }

    // HTML View Endpoints
    /**
     * Get a list of all Animals in the database.
     * Endpoint: GET  http://localhost:8080/animals/all
     *
     * @param model the model to add attributes to
     * @return the animal-list template
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        List<Animal> animals = service.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * Endpoint: GET http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal
     * @param model the model to add attributes to
     * @return the animal-details template
     */
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        Animal animal = service.getAnimalById(animalId);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "animal-details";
        }
        return "redirect:/animals/all";
    }

    /**
     * Show the create animal form.
     * Endpoint: GET http://localhost:8080/animals/new
     *
     * @return the animal-create template
     */
    @GetMapping("/new")
    public String showCreateForm() {
        return "animal-create";
    }

    /**
     * Create a new Animal.
     * Endpoint: POST http://localhost:8080/animals/new
     *
     * @param animal the Animal object to be added
     * @return redirect to the animal list
     */
    @PostMapping("/new")
    public String addNewAnimal(@ModelAttribute Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    /**
     * Show the update animal form.
     * Endpoint: GET http://localhost:8080/animals/update/2
     *
     * @param animalId the unique Animal Id
     * @param model the model to add attributes to
     * @return the animal-update template
     */
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        Animal animal = service.getAnimalById(animalId);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "animal-update";
        }
        return "redirect:/animals/all";
    }

    /**
     * Update an existing Animal.
     * Endpoint: POST http://localhost:8080/animals/update/2
     *
     * @param animalId the unique Animal Id
     * @param animal the Animal object with updated details
     * @return redirect to the animal list
     */
    @PostMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, @ModelAttribute Animal animal) {
        Animal existingAnimal = service.getAnimalById(animalId);
        if (existingAnimal != null) {
            service.updateAnimal(animalId, animal);
        }
        return "redirect:/animals/all";
    }

    /**
     * Delete an Animal by Id.
     * Endpoint: POST http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id
     * @return redirect to the animal list
     */
    @PostMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        Animal animal = service.getAnimalById(animalId);
        if (animal != null) {
            service.deleteAnimalById(animalId);
        }
        return "redirect:/animals/all";
    }
}
