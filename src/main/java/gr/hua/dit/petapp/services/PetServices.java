package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.Pet;
import gr.hua.dit.petapp.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PetServices {
    private PetRepository petRepository;

    public PetServices(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Transactional
    public Pet getPetById(Integer id) {
        return petRepository.findById(id).orElse(null);
    }

    @Transactional
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional
    public void deletePet(Integer id) {
        petRepository.deleteById(id);
    }

    @Transactional
    public void ApprovePetVet(Integer id, Pet pet){
        Pet pet1 = getPetById(id);
        pet1.setHealthStatus(pet.getHealthStatus());
        savePet(pet1);
    }
    @Transactional
    public void ApprovePetAdmin(Integer id, Pet pet){
        Pet pet1 = getPetById(id);
        pet1.setAge(pet.getAge());
        pet1.setStatus(pet.getStatus());
        pet1.setBreed(pet.getBreed());
        pet1.setHeight(pet.getHeight());
        pet1.setPicture(pet.getPicture());
        pet1.setName(pet.getName());
        pet1.setAdoptionStatus(pet.getAdoptionStatus());
        pet1.setShelter(pet.getShelter());
        pet1.setSex(pet.getSex());
        pet1.setHealthStatus(pet.getHealthStatus());
        pet1.setType(pet.getType());
        pet1.setHeight(pet.getHeight());
        savePet(pet1);


    }
    @Transactional
    public void ChangeStatusPet(Integer id, Pet pet){
        Pet pet1 = getPetById(id);
        pet1.setAge(pet.getAge());
        pet1.setBreed(pet.getBreed());
        pet1.setHeight(pet.getHeight());
        pet1.setPicture(pet.getPicture());
        pet1.setName(pet.getName());
        pet1.setAdoptionStatus(pet.getAdoptionStatus());
        pet1.setShelter(pet.getShelter());
        pet1.setSex(pet.getSex());
        pet1.setType(pet.getType());
        pet1.setHeight(pet.getHeight());
        savePet(pet1);


    }


}

