package gr.hua.dit.petapp.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class Shelter extends User{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;*/

    @OneToMany(mappedBy = "shelter")
    private List<Pet> pet;

    /*@ManyToOne
    @JoinColumn(name="Adminid")
    private Admin admin;*/

    private String Region;

    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING;

    public Shelter(){

    }

    public Shelter(List<Pet> pet,/*Admin admin, */String Region,AccountStatus status) {
        this.pet = pet;
        //this.admin = admin;
        this.Region = Region;
        this.status = status;
    }
    public Shelter(String Region)
    {
        this.Region = Region;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }
}
