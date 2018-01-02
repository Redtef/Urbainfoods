/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Categorie;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Yassine
 */
public class RestoListerSpecialiteHelper extends AbstractHelper<Categorie> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Specialités", "nom")
        };

    }
    

    public RestoListerSpecialiteHelper(JTable jTable, List<Categorie> list) {
        super(titres, jTable, list);
    }

    public RestoListerSpecialiteHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public RestoListerSpecialiteHelper(JTable jTable) {
        super(titres, jTable);
    }
}
