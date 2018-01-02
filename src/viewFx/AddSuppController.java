/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import bean.Client;
import bean.Ingredient;
import bean.LignePanier;
import bean.LigneSupplement;
import bean.Panier;
import bean.PricingFood;
import bean.PricingSupplement;
import bean.Supplement;
import helperfx.ChoixSupplementFxHelper;
import helperfx.SupplementFxHelper;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.CompositionService;
import service.LignePanierService;
import service.LigneSupplementService;
import service.PanierService;
import service.PricingSupplementService;
import service.SupplementService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author delll
 */
public class AddSuppController implements Initializable {

    @FXML
    private Label food;
    @FXML
    private Label prix;
    @FXML
    private ComboBox<String> qte;
    @FXML
    private Label ingredient;
    @FXML
    private Button ajouterAuPanier;
    @FXML
    private TableView<PricingSupplement> supps;
    @FXML
    private TableView<PricingSupplement> choisis;  
    
    CompositionService compositionService = new CompositionService();
    SupplementService supplementService = new SupplementService();
    PricingSupplementService pricingSupplementService = new PricingSupplementService();
    LigneSupplementService ligneSupplementService = new LigneSupplementService();
    LignePanierService lignePanierService = new LignePanierService();
    PanierService panierService = new PanierService();
    
    
    public void initQte(){
        
        for(int i=1;i<11;i++){
            qte.getItems().add(""+i);
        }
        
    }
    
    public void initIngredients(){
       
     List<Ingredient> ingredients = compositionService.findByCriteria(((PricingFood) Session.getAttribut("food")).getFood(), null);
        for (int i = 0; i < ingredients.size(); i++) {
            String get = ingredients.get(i).getNom();
            ingredient.setText(ingredient.getText()+get+", ");
        }
    }
    
    public void initSupp(){
        
        List<Supplement> supplements = supplementService.findByFood(((PricingFood) Session.getAttribut("food")).getFood());
        List<PricingSupplement> ps = new ArrayList();
        for (int i = 0; i < supplements.size(); i++) {
            PricingSupplement price = pricingSupplementService.findBy(((PricingFood) Session.getAttribut("food")).getRestaurant(), supplements.get(i));
            ps.add(price);
        }
        SupplementFxHelper supplementFxHelper = new SupplementFxHelper(supps, ps);
    }
    @FXML
    public void quantite(){
        
        
        
    }
    @FXML
    public void choixSupp(){
         List<PricingSupplement> ps = choisis.getItems();
         PricingSupplement p = supps.getSelectionModel().selectedItemProperty().get();
         int index = -1;
         for (int i = 0; i < ps.size(); i++) {
            PricingSupplement get = ps.get(i);
            if(ps.get(i).equals(p)){
                index=i;
            }
        }
//         if(qte.getValue().isEmpty()){
//         BigDecimal qt = new BigDecimal(1);
//                 }else {
//             BigDecimal qt = new BigDecimal(qte.getValue());
//         }
         BigDecimal pr = p.getPrix().multiply(new BigDecimal(qte.getValue()));
        if(index!=-1){
             ps.remove(index);
             prix.setText((new BigDecimal(prix.getText()).subtract(pr).toString()));
         }else{
             ps.add(p);
             prix.setText((new BigDecimal(prix.getText()).add(pr).toString()));
         }
     choisis.getColumns().clear();
     ChoixSupplementFxHelper choixSupplementFxHelper = new ChoixSupplementFxHelper(choisis, ps);
    }
    
    @FXML
    public void addPanier(){
        
        //CREATION DU PANIER
        
        Panier panier = (Panier) Session.getAttribut("panier");
        if(panier == null){
            panier = new Panier();
            panier.setResto(((PricingFood) Session.getAttribut("food")).getRestaurant());
            panier.setPrixTotal(new BigDecimal(prix.getText()));
            panier.setClient((Client) Session.getAttribut("conectedClient"));
        }
        
        //CREATION DU LIGNE PANIER
        
        LignePanier lignePanier = new LignePanier();
        lignePanierService.create(lignePanier);
        lignePanier.setFood(((PricingFood) Session.getAttribut("food")).getFood());
        lignePanier.setQte(Integer.parseInt(qte.getValue()));
        lignePanier.setPanier(panier);
        System.out.println(lignePanier);
        lignePanierService.edit(lignePanier);
        
        //CREATION DES LIGNES PANIER
        List<PricingSupplement> ps = choisis.getItems();
        for (int i = 0; i < ps.size(); i++) {
            Supplement get = ps.get(i).getSupplement();
            LigneSupplement ligneSupplement = new LigneSupplement(get, lignePanier);  
            ligneSupplementService.create(ligneSupplement);
        }
        
        
        //ADD LIGNE PANIER TO PANIER
        List<LignePanier> lignePaniers = panier.getLignePaniers();
        lignePaniers.add(lignePanier);
        panier.setLignePaniers(lignePaniers);
        if((Panier) Session.getAttribut("panier")==null){
        panierService.create(panier);
        }else{
            panierService.edit(panier);
        }
        
        Session.updateAttribute(panier, "panier");
        
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("CarteRestoFxml.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage nextstage = new Stage();
            nextstage.setScene(new Scene(root1));
            nextstage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Stage stage = (Stage) ajouterAuPanier.getScene().getWindow();
        stage.close();
      
   }
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        food.setText("" + ((PricingFood) Session.getAttribut("food")).getFood().getNom());
        prix.setText("" + ((PricingFood) Session.getAttribut("food")).getPrix());
        initQte();
        initIngredients();
        initSupp();
    }    
    
}
