/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Food;
import bean.Supplement;
import java.util.List;

/**
 *
 * @author Boss
 */
public class SupplementService extends AbstractFacade<Supplement> {

    public SupplementService() {
        super(Supplement.class);
    }
    
    public List<Supplement> findByFood(Food food){
        
        return getEntityManager().createQuery("select s from Supplement s where s.food.id ="+food.getId()).getResultList();
        
    }
    
}
