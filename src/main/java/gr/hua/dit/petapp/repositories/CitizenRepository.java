package gr.hua.dit.petapp.repositories;

import gr.hua.dit.petapp.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    Optional<Citizen> findByEmail(String email);
}
