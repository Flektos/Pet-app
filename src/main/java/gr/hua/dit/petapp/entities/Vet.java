package gr.hua.dit.petapp.entities;

import java.util.ArrayList;
import jakarta.persistence.*;
public class Vet extends User {
    private String Surname;

    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING; // Default to PENDING

    private ArrayList <String> ApprovedVPets;
    private ArrayList <String> NotApprovedVPets;
    private ArrayList <String> HealthRequest;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public ArrayList<String> getApprovedVPets() {
        return ApprovedVPets;
    }

    public void setApprovedVPets(ArrayList<String> approvedVPets) {
        ApprovedVPets = approvedVPets;
    }

    public ArrayList<String> getNotApprovedVPets() {
        return NotApprovedVPets;
    }

    public void setNotApprovedVPets(ArrayList<String> notApprovedVPets) {
        NotApprovedVPets = notApprovedVPets;
    }

    public ArrayList<String> getHealthRequest() {
        return HealthRequest;
    }

    public void setHealthRequest(ArrayList<String> notYetApprovedVPets) {
        HealthRequest = HealthRequest;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
