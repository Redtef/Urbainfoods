/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

//import bean.User;

import bean.Client;


/**
 *
 * @author moulaYounes
 */
public class UserDao extends AbstractDao<Client>{

    public UserDao() {
        super(Client.class);
    }
   
}
