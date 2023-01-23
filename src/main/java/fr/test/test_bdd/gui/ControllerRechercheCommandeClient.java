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
            result.close(); //ferme le resultat
            con.close();//ferme la connection
            BoxFournisseurs.setItems(model);

        } catch (Exception e) {
            e.getMessage();     //Message d'erreur
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mauvaise connection !");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }


    public void ClickSelect(ActionEvent mouseEvent) {
        String ID = BoxFournisseurs.getSelectionModel().getSelectedItem().getNumfou();
        StringBuilder commandesTexte = new StringBuilder();
        try {
            String url = "jdbc:mysql://localhost:3307/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "tiger");
            PreparedStatement stm2 = con.prepareStatement("SELECT numcom,datcom,obscom FROM entcom WHERE numfou=?");
            stm2.setString(1,ID);
            ResultSet result = stm2.executeQuery();
            //ObservableList<Commande> model2 = FXCollections.observableArrayList();

            while (result.next()){
                Commande com = new Commande(result.getString("numcom"),result.getString("datcom"),result.getString("obscom") );
               // model2.add(com);
                commandesTexte.append(com).append("\n");

            }
            result.close();                                                     //ferme le resultat
            con.close();                                                        //ferme la connection
            TextArea.setText(commandesTexte.toString());


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
