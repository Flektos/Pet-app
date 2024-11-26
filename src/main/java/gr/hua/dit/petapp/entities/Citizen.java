package gr.hua.dit.petapp.entities;

public class Citizen extends User{
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
