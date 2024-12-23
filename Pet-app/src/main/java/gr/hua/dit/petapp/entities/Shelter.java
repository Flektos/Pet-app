package gr.hua.dit.petapp.entities;
import java.util.ArrayList;
public class Shelter extends User{
    private String Region;
    private ArrayList <String> PetsList;
    private ArrayList <String> AdoptedPets;
    private ArrayList <String> CitizenList;
    private String status;

    private ArrayList <String> VisitRequests;

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public ArrayList<String> getPetList() {
        return PetsList;
    }

    public void setPetList(ArrayList<String> petList) {
        PetsList = petList;
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

    public ArrayList<String> getPetsList() {
        return PetsList;
    }

    public void setPetsList(ArrayList<String> petsList) {
        PetsList = petsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getVisitRequests() {
        return VisitRequests;
    }

    public void setVisitRequests(ArrayList<String> visitRequests) {
        VisitRequests = visitRequests;
    }
}
