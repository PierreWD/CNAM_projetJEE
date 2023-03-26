package org.example.servingwebcontent;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Nom;

    @ManyToOne
    @JoinColumn(name = "Adresse",referencedColumnName = "Adresse")
    private AdressesPostales Adresse;

    @ManyToOne
    @JoinColumn(name = "Email",referencedColumnName = "Email")
    private AdressesElectroniques Email;

    public Contact() {}

    public Contact(String Nom) {
        this.Nom = Nom;
    }
    public Contact(String Nom,AdressesPostales Adresse,AdressesElectroniques Email) {
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
        if(Adresse!=null){
            return Adresse.getAdresse();
        }else{
            return null;
        }
    }

    public void setAdresse(String adresse) {
        Adresse.setAdresse(adresse);
    }

    public void setAdresse(AdressesPostales adresse) {
        Adresse=adresse;
    }

    public String getEmail() {
        if(Email!=null){
            return Email.getEmail();
        }else{
            return null;
        }
    }

    public void setEmail(String email) {
        Email.setEmail(email);
    }

    public void setEmail(AdressesElectroniques email) {
        Email=email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Adresse='" + Adresse.getAdresse() + '\'' +
                ", Email='" + Email.getEmail() + '\'' +
                '}';
    }
}
