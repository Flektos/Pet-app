package gr.hua.dit.petapp.entities;
import java.util.ArrayList;
public class Shelter extends User{
    private String Region;
    private ArrayList <String> PetList;
    private ArrayList <String> AdoptedPets;
    private ArrayList <String> CitizenList;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public ArrayList<String> getPetList() {
        return PetList;
    }

    public void setPetList(ArrayList<String> petList) {
        PetList = petList;
    }

    public ArrayList<String> getAdoptedPets() {
        return AdoptedPets;
    }

    public void setAdoptedPets(ArrayList<String> adoptedPets) {
        AdoptedPets = adoptedPets;
    }

    public ArrayList<String> getCitizenList() {
        return CitizenList;
    }

    public void setCitizenList(ArrayList<String> citizenList) {
        CitizenList = citizenList;
    }
}
