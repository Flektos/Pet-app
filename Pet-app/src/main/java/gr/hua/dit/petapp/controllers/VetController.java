package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.Vet;
import gr.hua.dit.petapp.services.VetServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VetServices vetService;

    public VetController(VetServices vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public List<Vet> getAllVets() {
        return vetService.getAllVets();
    }

    @GetMapping("/{id}")
    public Vet getVetById(@PathVariable Integer id) {
        return vetService.getVetById(id);
    }

    @PostMapping
    public void addVet(@RequestBody Vet vet) {
        vetService.saveVet(vet);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable Integer id) {
        vetService.deleteVet(id);
    }
}
