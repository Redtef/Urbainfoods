/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author delll
 */
@Entity
public class Owner implements Serializable {

    @Id
    private String login;
    private String nom;
    private String prenom;
    private String telNumber;
    private String email;
    private String password;
    @OneToMany(mappedBy = "owner")
    private List<Restaurant> restaurants;

    public Owner() {
    }

    public Owner(String login) {
        this.login = login;
    }

    public Owner(String login, String nom, String prenom, String telNumber, String email, String password) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.telNumber = telNumber;
        this.email = email;
        this.password = password;
    }

    public Owner(String login, String nom, String prenom, String telNumber, String email, String password, List<Restaurant> restaurants) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.telNumber = telNumber;
        this.email = email;
        this.password = password;
        this.restaurants = restaurants;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.login);
        hash = 11 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public String toString() {
        return "Owner{" + "login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", telNumber=" + telNumber + ", email=" + email + ", password=" + password + ", adresse="+ '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Owner other = (Owner) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
      

    



  

 

    
    
}
