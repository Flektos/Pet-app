package gr.hua.dit.petapp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Historyid;
    private int petid;
    private int vetid;
    //private ArrayList <String> healthReport;

    public int getHistoryid() {
        return Historyid;
    }

    public void setHistoryid(int historyid) {
        Historyid = historyid;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public int getVetid() {
        return vetid;
    }

    public void setVetid(int vetid) {
        this.vetid = vetid;
    }

    /*public ArrayList<String> getHealthReport() {
        return healthReport;
    }

    public void setHealthReport(ArrayList<String> healthReport) {
        this.healthReport = healthReport;
    }*/
}
