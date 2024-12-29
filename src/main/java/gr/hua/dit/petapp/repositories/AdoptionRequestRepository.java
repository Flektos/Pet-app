package gr.hua.dit.petapp.repositories;

import gr.hua.dit.petapp.entities.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Integer> {
    List<AdoptionRequest> findByStatus(String status);
}
