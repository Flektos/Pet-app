package gr.hua.dit.petapp.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User {
    @OneToMany
    @JoinColumn(name="petid")
    private List<Pet> pet;

    @OneToMany
    @JoinColumn(name="shelterid")
    private List<Shelter> shelters;

    //@OneToMany(mappedBy = "admin")
    @OneToMany
    @JoinColumn(name = "adoptionrequestid")
    private List<AdoptionRequest> adoptionRequest;

    @Column
    private String surname;

    public Admin(){}

    public Admin(String surname,List<Pet> pet,List<Shelter> shelters,List<AdoptionRequest> adoptionRequest)
    {
        this.surname = surname;
        this.pet=pet;
        this.shelters=shelters;
        this.adoptionRequest=adoptionRequest;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    public List<AdoptionRequest> getAdoptionRequest() {
        return adoptionRequest;
    }

    public void setAdoptionRequest(List<AdoptionRequest> adoptionRequest) {
        this.adoptionRequest = adoptionRequest;
    }

    public List<Shelter> getShelters() {
        return shelters;
    }

    public void setShelters(List<Shelter> shelters) {
        this.shelters = shelters;
    }
}
