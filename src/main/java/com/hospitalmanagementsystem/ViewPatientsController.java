package com.hospitalmanagementsystem;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewPatientsController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private TableView<?> patientsTable;

    @FXML
    private TextField searchID;

    @FXML
    private Button searchButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code if any goes here
    }

    @FXML
    private void cancelButtonAction() {
                    try {
        // Load the home page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent homePage = loader.load();

        // Get the current stage using any component (e.g., the cancel button)
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        // Set the scene for the stage
        stage.setScene(new Scene(homePage));

        // Optionally, you can set the title for the stage if needed
        // stage.setTitle("Home Page");

        // Display the stage
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void searchButtonAction() {
        // Logic to search for a patient by ID
        String patientId = searchID.getText();

        // Now, use the patientId to query your database or perform search on your data structure
        
        // Update the patientsTable with the search results
    }
}
