/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Food;
import bean.Restaurant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boss
 */
public class CategorieService extends AbstractFacade<Categorie>{

    public CategorieService() {
        super(Categorie.class);
    }
    
    public void creerCat(String nom){
        Categorie c = new Categorie(nom);
        create(c);
    }
    
    public List<Categorie> findByAdresse(String ville,String cite){
        
        List<Restaurant> restos = getEntityManager().createQuery("SELECT r FROM Restaurant r where r.adresse.cite='" + cite + "' AND r.adresse.ville ='"  + ville +  "'").getResultList();
        List<Categorie> cats = new ArrayList();
        for (int i = 0; i < restos.size(); i++) {
            Restaurant resto = restos.get(i);
            List<Food> foods = resto.getCarte().getFoods();
             for (int j = 0; j < foods.size(); j++) {
                 cats.add(foods.get(j).getCategorie());
             }
    }
     return cats;
     
    }
}
