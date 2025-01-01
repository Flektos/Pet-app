package gr.hua.dit.petapp.entities;

import java.util.ArrayList;
import jakarta.persistence.*;
@Entity
public class Vet extends User {
    private String Surname;

    public Vet(){}

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
