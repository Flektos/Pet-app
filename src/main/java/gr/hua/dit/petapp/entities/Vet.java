package gr.hua.dit.petapp.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class Vet extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToMany
    @JoinColumn(name="petid")
    private List<Pet> pet;

    @OneToMany
    @JoinColumn(name="adminid")
    private List<Admin> admin;

    @OneToMany
    @JoinColumn(name="historyid")
    private List<MedicalHistory> medicalHistory;

    @OneToMany
    @JoinColumn(name="requestid")
    private List<AdoptionRequest> adoptionRequest;
    private String Surname;

    public Vet(){

    }

    public Vet(List<Pet> pet,List<Admin> admin,List<MedicalHistory> medicalHistory,List<AdoptionRequest> adoptionRequest){
        this.pet=pet;
        this.admin=admin;
        this.medicalHistory=medicalHistory;
        this.adoptionRequest=adoptionRequest;
    }

    public Vet(String Surname){
        this.Surname = Surname;
    }

    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING; // Default to PENDING


    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
