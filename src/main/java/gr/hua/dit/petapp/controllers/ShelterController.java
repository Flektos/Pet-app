package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.Shelter;
import gr.hua.dit.petapp.services.ShelterService;
import gr.hua.dit.petapp.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ShelterController {
    private ShelterService shelterService;

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
