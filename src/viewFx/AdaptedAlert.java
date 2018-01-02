/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import javafx.scene.control.ButtonType;

/**
 *
 * @author delll
 */
public class AdaptedAlert extends javafx.scene.control.Alert {

    public AdaptedAlert(AlertType alertType, String header,String title, String message) {
        super(alertType);
        this.setContentText(message);
        this.setTitle(title);
        this.setHeaderText(header);
        
    }
    
    
    
}
