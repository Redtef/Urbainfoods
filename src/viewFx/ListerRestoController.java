
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewFx;

import bean.Adresse;
import bean.Categorie;
import bean.Client;
import bean.Restaurant;
import helperfx.RestaurantFxHelper;
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
import service.RestaurantService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author delll
 */
public class ListerRestoController implements Initializable {

    @FXML
    private Label ville;
    @FXML
    private Button change;
    @FXML
    private Label categorie;
    @FXML
    private TableView<Restaurant> table;
     @FXML
    private Label client;

    RestaurantService restaurantService = new RestaurantService();
    @FXML
    private Button login;

    public Restaurant getParam(){
        
        String nom = table.getSelectionModel().selectedItemProperty().get().getNom();
        Restaurant resto = restaurantService.find(nom);
        return resto;
    }
    
    @FXML
    public void afficheCarte(){
        
        Restaurant resto = getParam();
        Session.updateAttribute(resto, "restaurant");
        Categorie c = new Categorie(categorie.getText());
        Session.updateAttribute(c, "categorie");
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("CarteRestoFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) table.getScene().getWindow();
        stage.close();
        
    }
    
    public void initTable() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAdresse((Adresse) Session.getAttribut("adresse"));
        Categorie cat = (Categorie) Session.getAttribut("categorie");
        List<Restaurant> restaurants = restaurantService.findRestoByCatF(restaurant.getAdresse(),
                 restaurant.getOwner(), restaurant.getCarte(), restaurant.getCategorie(), cat);
        RestaurantFxHelper restaurantFxHelper = new RestaurantFxHelper(table, restaurants);

    }

    @FXML
    public void change(ActionEvent actionEvent) {

        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AcceuilFxml.fxml"));
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
        ville.setText("" + ((Adresse) Session.getAttribut("adresse")).getVille());
        categorie.setText("" + ((Categorie) Session.getAttribut("categorie")).getNom());
        initTable();
        connect();
    }

}
