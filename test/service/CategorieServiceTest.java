/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delll
 */
public class CategorieServiceTest {
    
    public CategorieServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of creerCat method, of class CategorieService.
     */
    @Test
    public void testCreerCat() {
        System.out.println("creerCat");
        String nom = "burrito";
        CategorieService instance = new CategorieService();
        instance.creerCat(nom);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
