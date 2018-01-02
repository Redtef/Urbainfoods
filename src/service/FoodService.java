/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Food;
import bean.Carte;
import java.util.List;

/**
 *
 * @author Boss
 */
public class FoodService extends AbstractFacade<Food>{

    public FoodService() {
        super(Food.class);
    }
    
     public List<Food> findByCriteria(Carte menu,Categorie categorie,String nom) {
        String query = "SELECT f FROM Restaurant f WHERE 1=1";
        if (nom != null) {
            query += " AND f.nom='" + nom + "'";
        }
        if (menu != null) {
            query += " AND f.menu ='" + menu +"'";
        }
        if (categorie != null) {
            query += " AND f.specialite.nom ='" + categorie.getNom() +"'";
        }
        return getEntityManager().createQuery(query).getResultList();

    }
}
