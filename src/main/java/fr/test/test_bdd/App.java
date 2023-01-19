package fr.test.test_bdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage stage ;

    public static void changeFxml(String fxml) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(fxml+".fxml"));
        System.out.println(App.class.getResource(fxml+".fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(fxml+"!");
        stage.hide();
        stage.show();

    }
    @Override
    public void start(Stage stage2) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fr/test/test_bdd/Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = stage2;
        stage.setTitle("Menu exercice BDD!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}