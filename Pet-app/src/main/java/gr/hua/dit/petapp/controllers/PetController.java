package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.Pet;
import gr.hua.dit.petapp.services.PetServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetServices petService;

    public PetController(PetServices petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return petService.getPetById(id);
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
    }

    @PutMapping
    public void ChangeStatus(@PathVariable Integer id,@RequestBody Pet pet){
        petService.ChangeStatusPet(id,pet);
    }

    @PutMapping
    public void ApprovePetA(@PathVariable Integer id, @RequestBody Pet pet){
        petService.ApprovePetAdmin(id,pet);
    }

    @PutMapping
    public void ApprovedPetV(@PathVariable Integer id, @RequestBody Pet pet){
        petService.ApprovePetVet(id,pet);
    }
}

