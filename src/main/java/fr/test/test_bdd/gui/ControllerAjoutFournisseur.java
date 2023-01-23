package fr.test.test_bdd.gui;

import fr.test.test_bdd.App;
import fr.test.test_bdd.model.Fournisseur;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ControllerAjoutFournisseur {

    //Attribut utiliser
    public Text TextAjoutFournisseur;
    public TextField TextFieldNom;
    public TextField TextFieldRue;
    public TextField TextFieldContact;
    public TextField TextFieldCP;
    public TextField TextFieldVille;
    public Button BtnReturn;
    public Button BtnAjout;
    public Button BtnAnnuler;
    private static AtomicInteger count = new AtomicInteger();

    //Ajout a la base de donnée les valeur entrer avec verification regex
    public void BtnAjoutClick(ActionEvent actionEvent){

        try{
        //Connection BDD
        String url = "jdbc:mysql://localhost:3307/papyrus";
        Connection con = DriverManager.getConnection(url, "root", "tiger");

        int count = 9180;
        count++;

        //Creation objet pour effectuer des requêtes

        PreparedStatement stm = con.prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) " +
                                                        "VALUES (?, ?, ?, ?, ?, ?)");

        stm.setInt(1, count);
        stm.setString(2, TextFieldNom.getText());
        stm.setString(3, TextFieldRue.getText());
        stm.setString(4, TextFieldVille.getText());
        stm.setString(5, TextFieldCP.getText());
        stm.setString(6, TextFieldContact.getText());

        stm.execute();
        stm.close();
        con.close();

        //Confirmation de l'ajout
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.showAndWait();


    }catch (Exception e){                                           //Si la connection a la base de donnée ne fonctionne pas
        e.getMessage();                                             //Message d'erreur
        Alert alert = new Alert(Alert.AlertType.INFORMATION);       //Fenetre d'aller d'information
        alert.setTitle("Mauvaise connection !");                    //Titre Fenetre d'alerte
        alert.setContentText(e.getMessage());                     //Savoir precisement l'alerte
        alert.showAndWait();                                        //Fais apparaitre la fenetre et attend une validation de l'utilisateur

    }

    }
    //retire toute les entrer dans le questionnaire
    public void BtnAnnulerClick(ActionEvent actionEvent){
        TextFieldNom.clear();                                       //Enleve la valeur de nom
        TextFieldRue.clear();                                       //Enleve la valeur de rue
        TextFieldContact.clear();                                   //Enleve la valeur de contact
        TextFieldCP.clear();                                        //Enleve la valeur de CP
        TextFieldVille.clear();                                     //Enleve la valeur de ville

    }
    //retour au menu de selection
    public void BtnReturnClick(ActionEvent actionEvent) throws IOException {
        App.changeFxml("Menu");                                     //Renvoie la chaine de caractere a la function changeFXML pour retourner sur le menu

    }
}
