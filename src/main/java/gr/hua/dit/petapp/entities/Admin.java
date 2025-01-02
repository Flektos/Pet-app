package gr.hua.dit.petapp.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToMany
    @JoinColumn(name="petid")
    private List<Pet> pet;

    @OneToMany
    @JoinColumn(name="shelterid")
    private List<Shelter> shelters;

    @OneToMany
    @JoinColumn(name="requestid")
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
}
