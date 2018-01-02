/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author delll
 */
@Entity
public class Carte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nomResto;
    @OneToOne(mappedBy = "carte")
    private Restaurant restaurant;
    @OneToMany(mappedBy = "carte")
    private List<Food> foods;
    

    public String getNomResto() {
        return nomResto;
    }

    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Food> getFoods() {
        if (foods == null) {
            foods = new ArrayList();
        }
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Carte(String nomResto) {
        this.nomResto = nomResto;
    }

    public Carte() {
    }

    public String getId() {
        return nomResto;
    }

    public void setId(String id) {
        this.nomResto = id;
    }

    public Carte(String nomResto, Restaurant restaurant, List<Food> foods) {
        this.nomResto = nomResto;
        this.restaurant = restaurant;
        this.foods = foods;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomResto != null ? nomResto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nomResto fields are not set
        if (!(object instanceof Carte)) {
            return false;
        }
        Carte other = (Carte) object;
        if ((this.nomResto == null && other.nomResto != null) || (this.nomResto != null && !this.nomResto.equals(other.nomResto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "nomResto=" + nomResto + ", foods=" + foods + '}';
    }

   

}
