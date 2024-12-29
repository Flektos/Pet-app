package gr.hua.dit.petapp.repositories;

import gr.hua.dit.petapp.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
