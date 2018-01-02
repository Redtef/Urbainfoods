/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import bean.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ClientService;
import util.Session;
import view.Acceuil;

/**
 * FXML Controller class
 *
 * @author delll
 */
public class LoginController implements Initializable {

    service.ClientService clientService = new ClientService();
    
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    
    @FXML
    private Button connection;
    
    @FXML
    public void seConnecter(){
        Client client = getParam(); 
        
        int i = clientService.seConnecter(client);
        if (i == -2) {
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.ERROR,null,"Erreur","Password Incorrect");
            alert.showAndWait();
            
            
            } else if(i == -1){
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.ERROR,null,"Erreur","Ce Compte n'existe Pas.");
            alert.showAndWait();
        }
         else if(i >0){
            Session.updateAttribute(client, "conectedClient");
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.INFORMATION,null,"Succes","CONNECTION AVEC SUCCES BIENVENU : " + client.getLogin());
           alert.showAndWait();
            try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AcceuilFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
            } catch (Exception e) {
            e.printStackTrace();

           }
            
            Stage stage = (Stage) connection.getScene().getWindow();
            stage.close();        
      }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getConnection() {
        return connection;
    }

    public void setConnection(Button connection) {
        this.connection = connection;
    }
    
    private Client getParam() {
        Client client = new Client();
        client.setLogin(login.getText());
        client.setPassword(password.getText());
        return client;
    }
    
}
