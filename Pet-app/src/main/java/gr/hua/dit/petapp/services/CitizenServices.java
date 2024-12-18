package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.Citizen;
import gr.hua.dit.petapp.repositories.CitizenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServices {
    private CitizenRepository citizenRepository;

    public CitizenServices(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Transactional
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Transactional
    public Citizen getCitizenById(Integer id) {
        return citizenRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    @Transactional
    public void deleteCitizen(Integer id) {
        citizenRepository.deleteById(id);
    }



}
