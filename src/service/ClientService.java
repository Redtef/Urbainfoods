/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Client;

/**
 *
 * @author Boss
 */
public class ClientService extends AbstractFacade<Client>{

    public ClientService() {
        super(Client.class);
    }
    
    public int creer(String login , String nom , String prenom ){
        Client client = new Client(login, nom, prenom) ;
        create(client);
        return 1;
    }
    
    public int seConnecter(Client client) {
        Client load = find(client.getLogin());
        if (load == null) {
            return -1;
        } else if (!load.getPassword().equals(client.getPassword())) {
            return -2;
        } else {
            return 1;
        }
    }
}
