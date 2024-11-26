package gr.hua.dit.petapp.entities;
import java.util.ArrayList;
public class Vet extends User {
    private String Surname;
    private ArrayList <String> ApprovedVPets;
    private ArrayList <String> NotApprovedVPets;
    private ArrayList <String> NotYetApprovedVPets;

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

    public ArrayList<String> getNotYetApprovedVPets() {
        return NotYetApprovedVPets;
    }

    public void setNotYetApprovedVPets(ArrayList<String> notYetApprovedVPets) {
        NotYetApprovedVPets = notYetApprovedVPets;
    }
}
