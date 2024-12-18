package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.Citizen;
import gr.hua.dit.petapp.services.CitizenServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {
    private  CitizenServices citizenService;

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
}

