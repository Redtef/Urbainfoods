/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Adresse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boss
 */
public class AdresseService extends AbstractFacade<Adresse> {

    public AdresseService() {
        super(Adresse.class);
    }
    
    public List<Adresse> findAdresseResto(){
         List<Adresse> adresses = null;
            adresses = getEntityManager().createQuery("select r.adresse from Restaurant r ").getResultList();
         return adresses;
     }
    public List<String> findByVille(String ville){
        List<Adresse> adresses = getEntityManager().createQuery("select a from Adresse a where a.ville='" + ville + "'").getResultList();
        List<String> cites = new ArrayList();
        for (int i = 0; i < adresses.size(); i++) {
            Adresse get = adresses.get(i);
            cites.add(get.getCite());
            
        }
        return cites;
    }
}
