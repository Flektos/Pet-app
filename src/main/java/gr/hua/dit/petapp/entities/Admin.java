package gr.hua.dit.petapp.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.ArrayList;
@Entity
public class Admin extends User {
    @Column
    private String surname;

    public Admin(){}

    public Admin(String surname)
    {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
