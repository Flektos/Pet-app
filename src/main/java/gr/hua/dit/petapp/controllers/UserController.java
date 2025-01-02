package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.*;
import gr.hua.dit.petapp.exception.EmailAlreadyExistsException;
import gr.hua.dit.petapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private AdminService adminService;
    private  VetServices vetService;
    private PetServices petService;
    private ShelterService shelterService;
    private CitizenServices citizenService;

    @Autowired
    public UserController(UserService userService,AdminService adminService, VetServices vetService, PetServices petService,
                          ShelterService shelterService, CitizenServices citizenService) {
        this.userService = userService;
        this.adminService = adminService;
        this.vetService = vetService;
        this.petService = petService;
        this.shelterService = shelterService;
        this.citizenService = citizenService;
    }

    // ===================== Admin Endpoints =====================
   // @GetMapping("/admins")
    //public ResponseEntity<List<Map<String, Object>>> getAllAccounts() {
    //    List<Map<String, Object>> admins = adminService.getAllAccounts();
    //    return ResponseEntity.ok(admins);
    //}

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAccount(@RequestParam String email) {
        adminService.deleteAccount(email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userType}/{id}/approve")
    public ResponseEntity<String> approveAccount(@PathVariable String userType, @PathVariable Integer id) {
        adminService.approveAccount(userType, id);
        return ResponseEntity.ok("Account approved successfully.");
    }


    // ===================== Vet Endpoints =====================
    @GetMapping("/vets")
    public ResponseEntity<List<Vet>> getAllVets() {
        List<Vet> vets = vetService.getAllVets();
        return ResponseEntity.ok(vets);
    }

    @PostMapping("/vets")
    public ResponseEntity<String> addVet(@RequestBody Vet vet) {
        try {
            vetService.saveVet(vet);
            return new ResponseEntity<>("Vet account created successfully!", HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/vets/{id}")
    public ResponseEntity<Vet> updateVet(@PathVariable Integer id, @RequestBody Vet vetDetails) {
        Vet updatedVet = vetService.updateVet(id, vetDetails);
        return ResponseEntity.ok(updatedVet);
    }

    @DeleteMapping("/vets/{id}")
    public void deleteVet(@PathVariable Integer id) {
        vetService.deleteVet(id);
    }

    // ===================== Pet Endpoints =====================
    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/pets")
    public void addPet(@RequestBody Pet pet) {
        petService.savePet(pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }


    // ===================== Shelter Endpoints =====================
    @GetMapping("/shelters")
    public List<Shelter> getAllShelters() {
        return shelterService.getAllShelters();
    }


    @DeleteMapping("/shelter/{id}")
    public void deleteShelter(@PathVariable Integer id) {
        shelterService.deleteShelter(id);
    }



    @PostMapping("/shelters")
    public ResponseEntity<String> addShelter(@RequestBody Shelter shelter) {
        try {
            shelterService.saveShelter(shelter);
            return new ResponseEntity<>("Shelter account created successfully!", HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



    // ===================== Citizen Endpoints =====================
    @GetMapping("/citizens")
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        List<Citizen> citizens = citizenService.getAllCitizens();
        return ResponseEntity.ok(citizens);
    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Integer id) {
        citizenService.deleteCitizen(id);
    }

    @GetMapping
    public List <User> getAllAccounts(){
        List <User> users = userService.getAllAccounts();
        return users;
    }

}
