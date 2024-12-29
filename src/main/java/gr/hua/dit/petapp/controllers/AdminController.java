package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.*;
import gr.hua.dit.petapp.payload.response.MessageResponse;
import gr.hua.dit.petapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private VetServices vetService;

    @Autowired
    private CitizenServices citizenService;

    @Autowired
    private AdoptionRequestService adoptionRequestService;

    @PutMapping("/update-shelter/{id}")
    public ResponseEntity<?> updateShelterProfile(@PathVariable Integer id, @RequestBody Shelter shelterDetails) {
        try {
            shelterService.updateShelter(id, shelterDetails);
            return ResponseEntity.ok(new MessageResponse("Shelter profile updated successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @PutMapping("/update-vet/{id}")
    public ResponseEntity<?> updateVetProfile(@PathVariable Integer id, @RequestBody Vet vetDetails) {
        try {
            vetService.updateVet(id, vetDetails);
            return ResponseEntity.ok(new MessageResponse("Vet profile updated successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @PutMapping("/update-citizen/{id}")
    public ResponseEntity<?> updateCitizenProfile(@PathVariable Integer id, @RequestBody Citizen citizenDetails) {
        try {
            citizenService.updateCitizen(id, citizenDetails);
            return ResponseEntity.ok(new MessageResponse("Citizen profile updated successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/checkEmail")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = adminService.emailExists(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/{userType}/{id}/approve")
    public ResponseEntity<String> approveAccount(@PathVariable String userType, @PathVariable Integer id) {
        adminService.approveAccount(userType, id);
        return ResponseEntity.ok("Account approved successfully.");
    }

    @PostMapping("/{userType}/{id}/reject")
    public ResponseEntity<String> rejectAccount(@PathVariable String userType, @PathVariable Integer id,
                                                @RequestParam(required = false) String remarks) {
        adminService.rejectAccount(userType, id, remarks);
        return ResponseEntity.ok("Account rejected successfully.");
    }
    // Endpoint to fetch all accounts
    @GetMapping("/accounts")
    public ResponseEntity<List<Map<String, Object>>> getAllAccounts() {
        List<Map<String, Object>> accounts = adminService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Endpoint to delete an account by email
    @DeleteMapping("/account/delete")
    public ResponseEntity<?> deleteAccount(@RequestParam String email) {
        try {
            adminService.deleteAccount(email);
            return ResponseEntity.ok("Account deleted successfully, and an email notification has been sent.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Endpoint to filter adoption requests by status
    @GetMapping("/adoption-requests")
    public ResponseEntity<List<AdoptionRequest>> getAdoptionRequests(@RequestParam(required = false) String status) {
        List<AdoptionRequest> adoptionRequests;

        if (status != null && !status.isEmpty()) {
            adoptionRequests = adoptionRequestService.getAdoptionRequestsByStatus(status);
        } else {
            adoptionRequests = adoptionRequestService.getAllAdoptionRequests();
        }

        return ResponseEntity.ok(adoptionRequests);
    }
    // Get list of pets waiting for approval
    @GetMapping("/pending-pets")
    public ResponseEntity<List<Pet>> getPendingPets() {
        List<Pet> pendingPets = adminService.getPendingPets();
        return ResponseEntity.ok(pendingPets);
    }

    // Approve a specific pet
    @PutMapping("/approve-pet/{petId}")
    public ResponseEntity<String> approvePet(@PathVariable Integer petId) {
        adminService.approvePet(petId);
        return ResponseEntity.ok("Pet approved successfully.");
    }

    // Reject a specific pet
    @PutMapping("/reject-pet/{petId}")
    public ResponseEntity<String> rejectPet(@PathVariable Integer petId) {
        adminService.rejectPet(petId);
        return ResponseEntity.ok("Pet rejected successfully.");
    }
}
