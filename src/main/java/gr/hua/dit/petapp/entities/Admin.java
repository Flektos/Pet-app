package gr.hua.dit.petapp.entities;
import jakarta.persistence.Entity;

import java.util.ArrayList;
@Entity
public class Admin extends User {
    private String surname;
    //private ArrayList<String> ApprovedShelters;
    //private ArrayList<String> ApprovedPets;

    //private ArrayList<String> YetApprovedPets;

    //private ArrayList<String> AllAccounts;
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /*public ArrayList<String> getApprovedShelters() {
        return ApprovedShelters;
    }

    public void setApprovedShelters(ArrayList<String> approvedShelters) {
        ApprovedShelters = approvedShelters;
    }

    public ArrayList<String> getApprovedPets() {
        return ApprovedPets;
    }*/

    /*public void setApprovedPets(ArrayList<String> approvedPets) {
        ApprovedPets = approvedPets;
    }

    public ArrayList<String> getYetApprovedPets() {
        return YetApprovedPets;
    }


    public void setYetApprovedPets(ArrayList<String> yetApprovedPets) {
        YetApprovedPets = yetApprovedPets;
    }

    public ArrayList<String> getAllAccounts() {
        return AllAccounts;
    }

    public void setAllAccounts(ArrayList<String> allAccounts) {
        AllAccounts = allAccounts;
    }*/
}
