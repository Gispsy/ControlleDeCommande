package fr.test.test_bdd.gui;


import fr.test.test_bdd.App;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class ControllerMenu {

//Connection base de donnée papyprus
    public void  initialize(){
        try {

            Connection connection = null;
            String url = "jdbc:mysql://localhost:3307/papyrus";
            connection = DriverManager.getConnection(url, "root", "tiger");

            System.out.println("ça marche ");

        } catch (Exception e) {
            System.out.println("la connexion a échoué");
        }
    }


    public void OnClickR(ActionEvent actionEvent) throws IOException {

        App.changeFxml("RechercheClient");
    }

    public void OnClickJeu(ActionEvent actionEvent) throws IOException {

        App.changeFxml("RechercheCommandeClient");
    }

    public void OnClickInsertion(ActionEvent actionEvent) throws IOException {

        App.changeFxml("autre");
    }
}