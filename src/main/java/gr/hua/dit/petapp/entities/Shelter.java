package gr.hua.dit.petapp.entities;

import java.util.ArrayList;
import jakarta.persistence.*;
@Entity
public class Shelter extends User{
    private String Region;
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.PENDING;

    public Shelter() {}

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
}
