package com.hospitalmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginPageController implements Initializable {

    @FXML
    private TextField usernameId;
    @FXML
    private PasswordField passwordId;
    @FXML
    private Button loginButtonId;
    @FXML
    private Button cancelButtonId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoginButtonAction() {
        try {
            // Load HomePage.fxml
            Parent homePage = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            
            // Get the stage from any component e.g. loginButtonId
            Stage stage = (Stage) loginButtonId.getScene().getWindow();
            
            // Set the new scene to the stage
            stage.setScene(new Scene(homePage));

            // Optionally set the title of the stage
            // stage.setTitle("Home Page");

            // Display the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButtonAction() {
        // Get the stage from any component e.g. cancelButtonId
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close(); // Close the window
    }
}
