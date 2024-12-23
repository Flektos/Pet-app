package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.services.EmailService;
import gr.hua.dit.petapp.entities.Citizen;
import gr.hua.dit.petapp.services.CitizenServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {
    private  CitizenServices citizenService;
    private EmailService emailService;

    public CitizenController(CitizenServices citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable Integer id) {
        return citizenService.getCitizenById(id);
    }

    @PostMapping
    public void addCitizen(@RequestBody Citizen citizen) {
        citizenService.saveCitizen(citizen);
    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Integer id) {
        citizenService.deleteCitizen(id);
    }
    @PostMapping("/sendVisitRequest")
    public String sendVisitRequest(@RequestParam String citizenName, @RequestParam String shelterEmail) {
        emailService.sendVisitRequestEmail(citizenName, shelterEmail);
        return "Το email εστάλη επιτυχώς στο καταφύγιο: " + shelterEmail;
    }
}

