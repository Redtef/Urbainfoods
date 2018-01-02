/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.PricingSupplement;
import bean.Restaurant;
import bean.Supplement;
import java.math.BigDecimal;

/**
 *
 * @author delll
 */
public class PricingSupplementService extends AbstractFacade<PricingSupplement>{

    public PricingSupplementService() {
        super(PricingSupplement.class);
    }
    
    
    public PricingSupplement findBy(Restaurant resto,Supplement supp){
        
        return (PricingSupplement) getEntityManager().createQuery("select p from PricingSupplement p where p.restaurant.nom='" + resto.getNom()+"' and p.supplement.id='" +supp.getId()+ "'").getSingleResult();
        
    }
      
    public PricingSupplement findByN(Restaurant resto,String supp){
        
        return (PricingSupplement) getEntityManager().createQuery("select p from PricingSupplement p where p.restaurant.nom='" + resto.getNom()+"' and p.supplement.nom='" +supp+ "'").getSingleResult();
        
    }
    
}
