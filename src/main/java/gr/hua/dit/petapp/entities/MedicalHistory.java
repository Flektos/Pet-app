package gr.hua.dit.petapp.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int Historyid;
    @Column
    private int vetid;
    @OneToOne
    @JoinColumn(name = "petid")
    private Pet pet;


    public MedicalHistory() {
    }

    public MedicalHistory(int vetid, Pet pet) {
        this.vetid = vetid;
        this.pet = pet;
    }

    public int getHistoryid() {
        return Historyid;
    }

    public void setHistoryid(int historyid) {
        Historyid = historyid;
    }

    public int getVetid() {
        return vetid;
    }

    public void setVetid(int vetid) {
        this.vetid = vetid;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
