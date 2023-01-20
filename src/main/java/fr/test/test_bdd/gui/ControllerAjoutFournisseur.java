package fr.test.test_bdd.gui;

import fr.test.test_bdd.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerAjoutFournisseur {

    //Attribut utiliser
    public Text TextAjoutFournisseur;
    public TextField TextFieldNom;
    public TextField TextFieldRue;
    public TextField TextFieldContact;
    public TextField TextFieldCP;
    public TextField TextFieldVille;
    public Button BtnReturn;

    //Ajout a la base de donnée les valeur entrer avec verification regex
    public void BtnAjoutClick(ActionEvent actionEvent){
    try{


    }catch (Exception e){                                           //Si la connection a la base de donnée ne fonctionne pas
        e.getMessage();                                             //Message d'erreur
        Alert alert = new Alert(Alert.AlertType.INFORMATION);       //Fenetre d'aller d'information
        alert.setTitle("Mauvaise connection !");                    //Titre Fenetre d'alerte
        //alert.setContentText(e.getMessage());                     //Savoir precisement l'alerte
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
