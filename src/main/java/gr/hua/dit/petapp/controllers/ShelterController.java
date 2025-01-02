package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.Shelter;
import gr.hua.dit.petapp.entities.Vet;
import gr.hua.dit.petapp.services.ShelterService;
import gr.hua.dit.petapp.exception.EmailAlreadyExistsException;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelter")
public class ShelterController {

    private ShelterService shelterService;


    // Default constructor (required for JPA)


    // Parameterized constructor
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;

    }




    @GetMapping
    public List<Shelter> getAllShelters() {
        return shelterService.getAllShelters();
    }

    @GetMapping("/{id}")
    public Shelter getShelterById(@PathVariable Integer id) {
        return shelterService.getShelterById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShelter(@PathVariable Integer id) {
        shelterService.deleteShelter(id);
    }



    @PostMapping
    public ResponseEntity<String> addShelter(@RequestBody Shelter shelter) {
        try {
            shelterService.saveShelter(shelter);
            return new ResponseEntity<>("Shelter account created successfully!", HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
