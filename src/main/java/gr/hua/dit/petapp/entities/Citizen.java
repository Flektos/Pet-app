package gr.hua.dit.petapp.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Citizen extends User{
    private String surname;

    @Column
    @OneToMany
    private List<AdoptionRequest> adoptionRequestList;

    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING;

    public Citizen(){}

    public Citizen(String surname)
    {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<AdoptionRequest> getAdoptionRequestList() {
        return adoptionRequestList;
    }

    public void setAdoptionRequestList(List<AdoptionRequest> adoptionRequestList) {
        this.adoptionRequestList = adoptionRequestList;
    }
}
