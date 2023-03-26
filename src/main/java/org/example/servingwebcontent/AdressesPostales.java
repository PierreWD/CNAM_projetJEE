package org.example.servingwebcontent;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresses_postales")
public class AdressesPostales implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Adresse;

    public AdressesPostales() {}

    public AdressesPostales(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    @Override
    public String toString() {
        return "AdressesPostales{" +
                "id=" + id +
                ", Adresse='" + Adresse + '\'' +
                '}';
    }
}
