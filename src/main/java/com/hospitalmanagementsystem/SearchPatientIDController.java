package com.hospitalmanagementsystem;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchPatientIDController {

    @FXML
    private TextField patientID;

    @FXML
    private Button cancelButtonID;

    @FXML
    private Button searchButtonID;

    @FXML
    public void initialize() {
        // Initialization logic, if needed
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
    // Get the current stage using the cancel button and close it
    Stage stage = (Stage) cancelButtonID.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        // Logic for search button
        // Use patientID.getText() to get the ID entered by the user
    }

    // Additional methods or logic can be added as required.
}
