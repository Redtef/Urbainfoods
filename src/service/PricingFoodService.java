/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.PricingFood;
import bean.Restaurant;
import java.util.List;

/**
 *
 * @author delll
 */
public class PricingFoodService extends AbstractFacade<PricingFood>{

    public PricingFoodService() {
        super(PricingFood.class);
    }
    
    
    
    public List<PricingFood> findByCriteria(Restaurant resto , Categorie categorie ){
        String query = "SELECT pf FROM PricingFood pf WHERE 1=1";
        if (resto != null) {
            query += " AND pf.restaurant.nom ='" + resto.getNom() +"'";
        }
        if (categorie != null) {
            query += " AND pf.food.categorie.nom ='" + categorie.getNom() +"'";
        }
        return getEntityManager().createQuery(query).getResultList();
        
    }
    
    
}
