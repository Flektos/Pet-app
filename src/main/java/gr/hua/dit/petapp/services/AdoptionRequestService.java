package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.AdoptionRequest;
import gr.hua.dit.petapp.repositories.AdoptionRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdoptionRequestService {
    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    // List of valid statuses
    private final List<String> validStatuses = Arrays.asList("PENDING", "APPROVED", "REJECTED");

    @Transactional
    // Method to filter adoption requests by status
    public List<AdoptionRequest> getAdoptionRequestsByStatus(String status) {
        // Validate the status
        if (!validStatuses.contains(status)) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }

        // Fetch filtered adoption requests
        return adoptionRequestRepository.findByStatus(status);
    }

    @Transactional
    // Method to get all adoption requests
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestRepository.findAll();
    }
}
