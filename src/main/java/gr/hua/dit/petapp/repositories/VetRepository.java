package gr.hua.dit.petapp.repositories;

import gr.hua.dit.petapp.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {
    Optional<Vet> findByEmail(String email);
}

