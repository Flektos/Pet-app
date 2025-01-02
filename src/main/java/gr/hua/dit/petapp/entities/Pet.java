package gr.hua.dit.petapp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petid;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private int healthStatus;
    @Column
    private String adoptionStatus;
    @Column
    private int age;
    @Column
    private String picture;
    @Column
    private float weight;
    @Column
    private float height ;
    @Column
    private String breed;
    @Column
    private String sex;
    @Column
    private String Shelter;

    @ManyToOne
    @JoinColumn(name="citizenid")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name="adminid")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name="vetid")
    private Vet vet;

    @OneToOne
    @JoinColumn(name="historyid")
    private MedicalHistory medicalHistory;

    @OneToOne
    @JoinColumn(name="requestid")
    private AdoptionRequest adoptionRequest;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;

    public Pet(){

    }

    public Pet(Citizen citizen,Admin admin,Vet vet,MedicalHistory medicalHistory,AdoptionRequest adoptionRequest,ApprovalStatus status){
        this.citizen=citizen;
        this.admin=admin;
        this.vet=vet;
        this.medicalHistory=medicalHistory;
        this.adoptionRequest=adoptionRequest;
        this.status=status;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getShelter() {
        return Shelter;
    }

    public void setShelter(String shelter) {
        Shelter = shelter;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

}
