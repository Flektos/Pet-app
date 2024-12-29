package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.AdoptionRequest;
import gr.hua.dit.petapp.repositories.AdoptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRequestService {
    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    // Method to get all adoption requests
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestRepository.findAll();
    }
}
