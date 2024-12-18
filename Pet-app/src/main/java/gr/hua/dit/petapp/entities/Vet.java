package gr.hua.dit.petapp.entities;
import java.util.ArrayList;
public class Vet extends User {
    private String Surname;

    private String status;
    private ArrayList <String> ApprovedVPets;
    private ArrayList <String> NotApprovedVPets;
    private ArrayList <String> healthRequest;

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

    public ArrayList<String> gethealthRequest() {
        return healthRequest;
    }

    public void sethealthRequest(ArrayList<String> notYetApprovedVPets) {
        healthRequest = healthRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
