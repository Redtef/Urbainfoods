/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Composition;
import bean.Food;
import bean.Ingredient;
import java.util.List;

/**
 *
 * @author delll
 */
public class CompositionService extends AbstractFacade<Composition> {

    public CompositionService() {
        super(Composition.class);
    }
    
    
    public List<Ingredient> findByCriteria(Food food,Ingredient ingrediant){
        String query = "SELECT c.ingredient FROM Composition c WHERE 1=1";
        if (food != null) {
            query += " AND c.food.id ='" + food.getId() +"'";
        }
        if (ingrediant != null) {
            query += " AND r.ingredient.nom ='" + ingrediant.getNom() +"'";
        }
        return getEntityManager().createQuery(query).getResultList(); 
        
        
    }
    
    
}
