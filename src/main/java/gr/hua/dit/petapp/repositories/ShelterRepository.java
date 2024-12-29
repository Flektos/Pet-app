package gr.hua.dit.petapp.repositories;

import gr.hua.dit.petapp.entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    Optional<Shelter> findByEmail(String email);
}

