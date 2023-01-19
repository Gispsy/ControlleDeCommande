package fr.test.test_bdd.gui;

import fr.test.test_bdd.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class ControllerRechercheClient {
    //ID du tableau
    public TextField NomFournisseur;
    public TextField AdresseFournisseur;
    public TextField ContactFournisseur;
    public TextField CPFournisseur;
    public TextField VilleFournisseur;
    public TextField CodeFournisseur;
    public Button BtnRecherche; // recherche dans la BDD
    public Button BtnReturn;
    public Label LabelError;

    public Object OnClickRecherche(ActionEvent actionEvent) throws SQLException {
        String ID = CodeFournisseur.getText();
        try {

            //Connection BDD
            String url = "jdbc:mysql://localhost:3307/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "tiger");

            //Creation objet pour effectuer des requêtes
            PreparedStatement stm = con.prepareStatement("SELECT * FROM fournis WHERE numfou=? ");
            stm.setString(1,ID);

            ResultSet result = stm.executeQuery();//requete BDD

                    if(result.next() == true) {

                    NomFournisseur.setText(result.getString("nomfou"));
                    AdresseFournisseur.setText(result.getString("ruefou"));
                    CPFournisseur.setText(result.getString("posfou"));
                    VilleFournisseur.setText(result.getString("vilfou"));
                    ContactFournisseur.setText(result.getString("confou"));
                    LabelError.setText("  ");

                }else if(result.next() == false){

                        LabelError.setText("ERROR");
                        NomFournisseur.clear();
                        AdresseFournisseur.clear();
                        CPFournisseur.clear();
                        VilleFournisseur.clear();
                        ContactFournisseur.clear();


            }

            stm.close();        //Ferme l'objet
            con.close();        //ferme la connexion

            } catch (Exception e) {
            e.getMessage();     //Message d'erreur
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mauvaise connection !");
            alert.showAndWait();

            }
            return null;
    }

    public void BtnReturnClick(ActionEvent actionEvent)  throws IOException {   //Function return Menu
        App.changeFxml("Menu");

    }
}
