package helperfx;

import bean.PricingSupplement;
import java.util.List;

import javafx.scene.control.TableView;

public class SupplementFxHelper extends AbstractFxHelper<PricingSupplement> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Supplement :", "supplement"),
            new AbstractFxHelperItem("Prix :", "prix")
        };
    }

    public SupplementFxHelper(TableView<PricingSupplement> table, List<PricingSupplement> list) {
        super(titres, table, list);
    }

    public SupplementFxHelper(TableView<PricingSupplement> table) {
        super(titres, table);
    }

}
