/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Adresse;
import bean.Categorie;
import bean.Food;
import bean.Carte;
import bean.Owner;
import bean.Restaurant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boss
 */
public class RestaurantService extends AbstractFacade<Restaurant>{
    
    public RestaurantService() {
        super(Restaurant.class);
    }
    
    public void creerResto(String nom,String HOverture,String HFermeture,Boolean livraison,BigDecimal PrixL ,BigDecimal commission
                           ,Owner owner,Adresse adresse,Categorie specialite,Carte carte)
    {
     Restaurant restaurant = new Restaurant(nom, HOverture, HFermeture, livraison, PrixL, commission, adresse
                                         , owner, carte, specialite);
        create(restaurant);
        
    }
    
    public int modifierResto(String nom,String HOverture,String HFermeture,Boolean livraison,Long PrixL ,Float commission
                           ,Categorie specialite){
         String query = "UPDATE Restaurant r SET ";
            if (HOverture != null) {
            query += " r.heureOverture = '" + HOverture + "'";
        }
               if (HFermeture != null) {
            query += " r.heureFermeture = '" + HFermeture + "'";
        }
                   if (livraison != null) {
            query += " r.livraison = '" + livraison + "'";
        }
                    if (PrixL != null) {
            query += " r.prixLivraison = '" + PrixL + "'";
        }
                       if (commission != null) {
            query += " r.commission = '" + commission + "'";
        }
                         if (specialite != null) {
            query += " r.specialite = '" + specialite + "'";
        }
         query+= "where nom ='"+ nom +"'";
         return getEntityManager().createQuery(query).executeUpdate();
    }
    
     public List<Restaurant> findByCriteria(Adresse adresse,Owner owner,Carte carte,Categorie specialite) {
        String query = "SELECT r FROM Restaurant r WHERE 1=1";
        if (adresse != null) {
            query += " AND r.adresse.cite='" + adresse.getCite() + "' AND r.adresse.ville ='"  + adresse.getVille() +  "'";
        }
        if (owner != null) {
            query += " AND r.owner='" + owner + "'";
        }
        if (carte != null) {
            query += " AND r.carte ='" + carte +"'";
        }
        if (specialite != null) {
            query += " AND r.categorie ='" + specialite +"'";
        }
        return getEntityManager().createQuery(query).getResultList();

    }
     
    public List<Restaurant> findRestoByCatF(Adresse adresse,Owner owner,Carte carte,Categorie specialite,Categorie catFood){
         List<Restaurant> restos = findByCriteria(adresse, owner, carte, specialite);
         List<Restaurant> restof = new ArrayList();
         for (int i = 0; i < restos.size(); i++) {
            Restaurant resto = restos.get(i);
            int f = 0;
            List<Food> foods = resto.getCarte().getFoods();
             for (int j = 0; j < foods.size(); j++) {
                 Food food = foods.get(j);
                 if(food.getCategorie().equals(catFood)){
                   f=1;
                 }
             }
           if(f==1){
            restof.add(resto);
           }
        }
        
    return restof;
    }
     
}
