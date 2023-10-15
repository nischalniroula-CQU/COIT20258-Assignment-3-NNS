package com.hospitalmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private ConnectionClass connectionClass;

    @Override
    public void start(Stage stage) throws IOException {
        
        try {
            connectionClass = new ConnectionClass();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Could not establish a connection to the database!");
            // Optionally: Show an error message to the user and exit the application.
            System.exit(1);
        }

        scene = new Scene(loadFXML("Login Page"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
