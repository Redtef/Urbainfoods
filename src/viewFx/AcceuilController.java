/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import bean.Adresse;
import bean.Categorie;
import bean.Client;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.AdresseService;
import service.CategorieService;
import util.Session;

/**
 *
 * @author delll
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button Lister;
    @FXML
    private ComboBox<String> comboVille;
    @FXML
    private ComboBox<String> comboCite;
    @FXML
    private ComboBox<String> comboSpecialite;

    AdresseService adresseService = new AdresseService();
    CategorieService categorieService = new CategorieService();
    @FXML
    private Label client;

    private void handleButtonAction(ActionEvent event) {

    }
    @FXML
    private void initCat() {
        List<Categorie> lists = categorieService.findByAdresse(comboVille.getValue(), comboCite.getValue());
        List<String> catsDouble = new ArrayList();
        comboSpecialite.getItems().clear();
        for (int i = 0; i < lists.size(); i++) {
            Categorie c = lists.get(i);
            catsDouble.add(c.getNom().toLowerCase());
        }
       List<String> cats = new ArrayList(new HashSet(catsDouble));
       for (int i = 0; i < cats.size(); i++) {
            String v = cats.get(i);
            comboSpecialite.getItems().add(v);
        }
    }

    public void initVille() {
        List<Adresse> adresses = adresseService.findAdresseResto();

        List<String> villesDouble = new ArrayList();
        for (int i = 0; i < adresses.size(); i++) {
            Adresse a = adresses.get(i);
            villesDouble.add(a.getVille().toLowerCase());
        }

        List<String> villes = new ArrayList(new HashSet(villesDouble));
        for (int i = 0; i < villes.size(); i++) {
            String v = villes.get(i);
            comboVille.getItems().add(v);
        }
    }

    @FXML
    public void citeCombo() {
        String v = comboVille.getValue();
        List<Adresse> adresses = adresseService.findAdresseResto();
        comboCite.getItems().clear();
        List<String> citesDouble = new ArrayList();
        for (int i = 0; i < adresses.size(); i++) {
            Adresse a = adresses.get(i);
            if (a.getVille().equalsIgnoreCase(v)) {
                citesDouble.add(a.getCite().toLowerCase());
            }
        }

        List<String> cites = new ArrayList(new HashSet(citesDouble));
        for (int i = 0; i < cites.size(); i++) {
            String c = cites.get(i);
            comboCite.getItems().add(c);
        }
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

    @FXML
    public void Lister() {
        Adresse adresse = new Adresse();
        String v = comboVille.getValue();
        String c = comboCite.getValue();
        adresse.setCite(c);
        adresse.setVille(v);
        Categorie categorie = new Categorie(comboSpecialite.getValue());
        Session.updateAttribute(adresse, "adresse");
        Session.updateAttribute(categorie, "categorie");
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("ListerRestoFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) Lister.getScene().getWindow();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCat();
        initVille();
        connect();
        }

   }
