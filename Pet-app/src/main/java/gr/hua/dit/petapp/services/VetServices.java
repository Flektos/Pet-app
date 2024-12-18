package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.Vet;
import gr.hua.dit.petapp.repositories.VetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetServices {
    private final VetRepository vetRepository;

    public VetServices(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Transactional
    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    @Transactional
    public Vet getVetById(Integer id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveVet(Vet vet) {
        vetRepository.save(vet);
    }

    @Transactional
    public void deleteVet(Integer id) {
        vetRepository.deleteById(id);
    }
}

