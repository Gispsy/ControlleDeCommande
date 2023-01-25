package fr.test.test_bdd.gui;

import fr.test.test_bdd.App;
import fr.test.test_bdd.model.Commande;
import fr.test.test_bdd.model.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.sql.*;

public class ControllerRechercheCommandeClient {
    public javafx.scene.text.Text Text;
    public  ComboBox<Fournisseur> BoxFournisseurs;
    public javafx.scene.control.TextArea TextArea;
    public Button Return;
    private String com;
    Fournisseur fou2 = new Fournisseur("tout", "0");

    public void initialize() {
        try {
            //Connection BDD
            String url = "jdbc:mysql://localhost:3307/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "tiger");

            //Creation objet pour effectuer des requêtes
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT nomfou,numfou FROM fournis ");//requete BDD
            ObservableList<Fournisseur> model = FXCollections.observableArrayList();

            while (result.next())
            {
                Fournisseur fou = new Fournisseur(result.getString("fournis.nomfou"),result.getString("fournis.numfou"));
                model.add(fou);

            }
            model.add(fou2);



            result.close();                 //ferme le result
            con.close();                    //ferme la connection
            BoxFournisseurs.setItems(model);

        } catch (Exception e) {
            e.getMessage();                 //Message d'erreur
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mauvaise connection !");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }

    public void ClickSelect(ActionEvent actionEvent) {
        //String ID = BoxFournisseurs.getSelectionModel().getSelectedItem().getNumfou();
        Fournisseur fournisseur = BoxFournisseurs.getSelectionModel().getSelectedItem();
        StringBuilder commandesTexte = new StringBuilder();
        try {
            String url = "jdbc:mysql://localhost:3307/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "tiger");

            if(fournisseur.getNomfou().equals("tout")){
                PreparedStatement stm = con.prepareStatement("SELECT numcom,datcom,obscom FROM entcom");
                ResultSet result1 = stm.executeQuery();

                while(result1.next()){
                    Commande com1 = new Commande(result1.getString("numcom"), result1.getString("datcom"), result1.getString("obscom") );
                   commandesTexte.append(com1).append("\n");

                }
                result1.close();                                                     //ferme le resultat
                con.close();                                                        //ferme la connection
                TextArea.setText(commandesTexte.toString());

            }else{
                PreparedStatement stm2 = con.prepareStatement("SELECT numcom,datcom,obscom FROM entcom WHERE numfou=?");
                stm2.setString(1, fournisseur.getNumfou());
                ResultSet result = stm2.executeQuery();

                while (result.next()){
                    Commande com = new Commande(result.getString("numcom"),result.getString("datcom"),result.getString("obscom") );
                    commandesTexte.append(com).append("\n");

                }
                result.close();                                                     //ferme le resultat
                con.close();                                                        //ferme la connection
                TextArea.setText(commandesTexte.toString());

            }


        }catch (Exception e){
            e.getMessage();     //Message d'erreur
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mauvaise connection !");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }
    public void BtnReturnClick(ActionEvent actionEvent)  throws IOException {   //Function return Menu
        App.changeFxml("Menu");

    }
}
