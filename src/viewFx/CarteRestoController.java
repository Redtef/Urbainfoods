
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewFx;

import bean.Carte;
import bean.Categorie;
import bean.Client;
import bean.PricingFood;
import bean.Restaurant;
import helperfx.CarteFxHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.PricingFoodService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author delll
 */
public class CarteRestoController implements Initializable {

    @FXML
    private Button change;
    @FXML
    private Label categorie;
    @FXML
    private Button login;
    @FXML
    private Label restaurant;
    @FXML
    private TableView<PricingFood> table;
     @FXML
    private Label client;

    PricingFoodService pricingFoodService = new PricingFoodService();
    
    @FXML
    public void change(ActionEvent actionEvent) {

        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("ListerRestoFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) change.getScene().getWindow();
        stage.close();

    }
    
    @FXML
    public void login() {

        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) login.getScene().getWindow();
        stage.close();

    }
    
    public void initTable() {
        Carte carte = ((Restaurant) Session.getAttribut("restaurant")).getCarte();
        List<PricingFood> pricingFoods = pricingFoodService.findByCriteria((Restaurant) Session.getAttribut("restaurant"), (Categorie) Session.getAttribut("categorie"));
       CarteFxHelper carteFxHelper = new CarteFxHelper(table, pricingFoods);

    }
    
    public PricingFood getParam(){
        
        PricingFood pf = table.getSelectionModel().selectedItemProperty().get();
        return pf;
    }
    
    @FXML
    public void Supp() {

        PricingFood pricingFood = getParam();
        Session.updateAttribute(pricingFood, "food");
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AddSuppFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) change.getScene().getWindow();
        stage.close();

    }
    
    public void connect(){
        Client c = (Client) Session.getAttribut("conectedClient");
        
        if(c == null){
         client.setText("");
        }else{
         login.setManaged(false);
         client.setText("BONJOUR : " + ((Client) Session.getAttribut("conectedClient")).getLogin());
        }
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        categorie.setText(""+ ((Categorie) Session.getAttribut("categorie")).getNom());
        restaurant.setText(""+((Restaurant) Session.getAttribut("restaurant")).getNom());
        initTable();
        connect();
    }    

    
}
