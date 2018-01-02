package helperfx;

import bean.PricingSupplement;
import java.util.List;

import javafx.scene.control.TableView;

public class ChoixSupplementFxHelper extends AbstractFxHelper<PricingSupplement> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Supplement Choisis:", "supplement")
        };
    }

    public ChoixSupplementFxHelper(TableView<PricingSupplement> table, List<PricingSupplement> list) {
        super(titres, table, list);
    }

    public ChoixSupplementFxHelper(TableView<PricingSupplement> table) {
        super(titres, table);
    }

}
