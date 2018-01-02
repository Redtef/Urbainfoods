/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Yassine
 */
@Entity
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    private String heureOuverture;
    private String heureFermeture;
    private Boolean livraison;
    private BigDecimal prixLivraison;
    private BigDecimal commission;
    @OneToOne
    private Adresse adresse;
    @ManyToOne
    private Owner owner;
    @OneToOne
    private Carte carte; 
    @OneToOne
    private Categorie categorie;
    
    
    public Restaurant() {
    }

    public Restaurant(String nom, String heureOuverture, String heureFermeture, Boolean livraison, BigDecimal prixLivraison, BigDecimal commission, Adresse adresse, Owner owner, Carte carte, Categorie specialite) {
        this.nom = nom;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.livraison = livraison;
        this.prixLivraison = prixLivraison;
        this.commission = commission;
        this.adresse = adresse;
        this.owner = owner;
        this.carte = carte;
        this.categorie = specialite;
    }


    public Restaurant(String nom, String heureOuverture, String heureFermeture, Boolean livraison, BigDecimal prixLivraison, BigDecimal commission, Owner owner, Carte carte, Categorie categorie) {
        this.nom = nom;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.livraison = livraison;
        this.prixLivraison = prixLivraison;
        this.commission = commission;
        this.owner = owner;
        this.carte = carte;
        this.categorie = categorie;
    }

    
    
    public Restaurant(String heureOuverture, String heureFermeture, Boolean livraison, BigDecimal prixLivraison, BigDecimal commission) {
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.livraison = livraison;
        this.prixLivraison = prixLivraison;
        this.commission = commission;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public String getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(String heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public Boolean getLivraison() {
        return livraison;
    }

    public void setLivraison(Boolean livraison) {
        this.livraison = livraison;
    }

    public BigDecimal getPrixLivraison() {
        return prixLivraison;
    }

    public void setPrixLivraison(BigDecimal prixLivraison) {
        this.prixLivraison = prixLivraison;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nom fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "nom=" + nom + ", heureOuverture=" + heureOuverture + ", heureFermeture=" + heureFermeture + ", prixLivraison=" + prixLivraison + ", commission=" + commission + ", adresse=" + adresse + ", owner=" + owner + ", carte=" + carte + ", categorie=" + categorie + '}';
    }


}
