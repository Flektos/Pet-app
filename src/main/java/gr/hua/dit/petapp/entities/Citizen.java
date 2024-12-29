package gr.hua.dit.petapp.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
@Entity
public class Citizen extends User{
    private String surname;
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING;

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
}
