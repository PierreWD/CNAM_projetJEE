package org.example.servingwebcontent;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresses_electroniques")
public class AdressesElectroniques implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Email;

    public AdressesElectroniques() {}

    public AdressesElectroniques(String Email) {
        this.Email = Email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "AdressesElectroniques{" +
                "id=" + id +
                ", Email='" + Email + '\'' +
                '}';
    }
}
