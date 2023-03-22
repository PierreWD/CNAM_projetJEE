package org.example.servingwebcontent;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String Nom;
    private String Adresse;
    private String Email;

    public Contact() {}

    public Contact(String Nom) {
        this.Nom = Nom;
    }
    public Contact(String Nom,String Adresse,String Email) {
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Email = Email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
