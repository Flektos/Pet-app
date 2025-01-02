package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.*;
import gr.hua.dit.petapp.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private AdminService adminService;
    private VetServices vetService;
    private PetServices petService;
    private  ShelterService shelterService;
    private CitizenServices citizenService;

    private CitizenRepository citizenRepository;
    private ShelterRepository shelterRepository;
    private VetRepository vetRepository;

    @Autowired
    public UserService(AdminService adminService, VetServices vetService, PetServices petService,
                       ShelterService shelterService, CitizenServices citizenService,
                       CitizenRepository citizenRepository, ShelterRepository shelterRepository,
                       VetRepository vetRepository) {
        this.adminService = adminService;
        this.vetService = vetService;
        this.petService = petService;
        this.shelterService = shelterService;
        this.citizenService = citizenService;
        this.citizenRepository = citizenRepository;
        this.shelterRepository = shelterRepository;
        this.vetRepository = vetRepository;
    }
    @Transactional
    public List<User> getAllAccounts() {
        List<User> allAccounts = new ArrayList<>();

        // Add citizens
        List<Citizen> citizens = citizenRepository.findAll();
        allAccounts.addAll(citizens);

        // Add shelters
        List<Shelter> shelters = shelterRepository.findAll();
        allAccounts.addAll(shelters);

        // Add vets
        List<Vet> vets = vetRepository.findAll();
        allAccounts.addAll(vets);

        return allAccounts;
    }
}
