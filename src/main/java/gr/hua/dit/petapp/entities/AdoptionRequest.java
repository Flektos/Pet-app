package gr.hua.dit.petapp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int requestid;
    @OneToOne
    @JoinColumn(name = "petid")
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "citizenid")
    private Citizen citizen;

    @OneToMany
    @JoinColumn(name="adminid")
    private List<Admin> admin;
    @Column
    private String status;

    public AdoptionRequest() {
    }

    public AdoptionRequest(Pet pet, int requestid, String status, Citizen citizen , List<Admin> admin) {
        this.pet = pet;
        this.requestid = requestid;
        this.status = status;
        this.citizen = citizen;
        this.admin = admin;
    }

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
