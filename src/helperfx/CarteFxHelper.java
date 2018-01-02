package helperfx;

import bean.PricingFood;
import java.util.List;

import javafx.scene.control.TableView;

public class CarteFxHelper extends AbstractFxHelper<PricingFood> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Foods :", "food"),
            new AbstractFxHelperItem("Prix", "prix")};
    }
    
    public CarteFxHelper(TableView<PricingFood> table, List<PricingFood> list) {
        super(titres, table, list);
    }

    public CarteFxHelper(TableView<PricingFood> table) {
        super(titres, table);
    }
    
  
    
}
