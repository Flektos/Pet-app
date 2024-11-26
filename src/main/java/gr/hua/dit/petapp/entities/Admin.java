package gr.hua.dit.petapp.entities;
import java.util.ArrayList;
public class Admin extends User {
    private String surname;
    private ArrayList<String> ApprovedShelters;
    private ArrayList<String> ApprovedPets;
    private ArrayList<String> ApprovedVets;
    private ArrayList<String> ApprovedCitizens;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<String> getApprovedShelters() {
        return ApprovedShelters;
    }

    public void setApprovedShelters(ArrayList<String> approvedShelters) {
        ApprovedShelters = approvedShelters;
    }

    public ArrayList<String> getApprovedPets() {
        return ApprovedPets;
    }

    public void setApprovedPets(ArrayList<String> approvedPets) {
        ApprovedPets = approvedPets;
    }

    public ArrayList<String> getApprovedVets() {
        return ApprovedVets;
    }

    public void setApprovedVets(ArrayList<String> approvedVets) {
        ApprovedVets = approvedVets;
    }

    public ArrayList<String> getApprovedCitizens() {
        return ApprovedCitizens;
    }

    public void setApprovedCitizens(ArrayList<String> approvedCitizens) {
        ApprovedCitizens = approvedCitizens;
    }
}
