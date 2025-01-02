package gr.hua.dit.petapp.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Historyid;
    @ManyToOne
    @JoinColumn(name = "vetid")
    private Vet vet;

    @OneToOne
    @JoinColumn(name = "petid")
    private Pet pet;


    public MedicalHistory() {
    }

    public MedicalHistory(Vet vet, Pet pet) {
        this.vet = vet;
        this.pet = pet;
    }

    public Long getHistoryid() {
        return Historyid;
    }

    public void setHistoryid(Long historyid) {
        Historyid = historyid;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
