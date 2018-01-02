/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Categorie;
import bean.Restaurant;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Yassine
 */
public class RestoListerHelper extends AbstractHelper<Restaurant> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("", "image"),
            new AbstractHelperItem("", "nom"),
            new AbstractHelperItem("", "categorie")
            
        };

    }
    

    public RestoListerHelper(JTable jTable, List<Restaurant> list) {
        super(titres, jTable, list);
    }

    public RestoListerHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public RestoListerHelper(JTable jTable) {
        super(titres, jTable);
    }
}
