package helperfx;

import bean.Restaurant;
import java.util.List;

import javafx.scene.control.TableView;

public class RestaurantFxHelper extends AbstractFxHelper<Restaurant> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Restaurants :", "nom"),
            new AbstractFxHelperItem("heure  D'Ouverture :", "heureOuverture"),
            new AbstractFxHelperItem("Heure De Fermeture :", "heureFermeture")
        };
    }

    public RestaurantFxHelper(TableView<Restaurant> table, List<Restaurant> list) {
        super(titres, table, list);
    }

    public RestaurantFxHelper(TableView<Restaurant> table) {
        super(titres, table);
    }

}
