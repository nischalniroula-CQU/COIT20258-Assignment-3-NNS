package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class RegisterPatientsController {

    @FXML
    private TextField patientID;

    @FXML
    private TextField firstNameID;

    @FXML
    private TextField lastNameID;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private ChoiceBox<String> bloodGroupChoiceBox;

    @FXML
    private ChoiceBox<String> DepartmentChoiceBox1;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    @FXML
    public void initialize() {
        // This method is called after the fxml file is loaded.

        // Populate genderChoiceBox
        genderChoiceBox.getItems().addAll("Male", "Female", "Other");

        // Populate bloodGroupChoiceBox
        bloodGroupChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

        // Populate DepartmentChoiceBox1
        DepartmentChoiceBox1.getItems().addAll("Cardiology", "Neurology", "Orthopedics", "Dermatology", "Emergency");
    }

    @FXML
    private void cancelButtonAction(ActionEvent event) {
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
    private void submitButtonAction(ActionEvent event) {
        // Handle the submit button logic here.

        String patientId = patientID.getText();
        String firstName = firstNameID.getText();
        String lastName = lastNameID.getText();
        String dob = (dobPicker.getValue() != null) ? dobPicker.getValue().toString() : null;
        String gender = genderChoiceBox.getSelectionModel().getSelectedItem();
        String bloodGroup = bloodGroupChoiceBox.getSelectionModel().getSelectedItem();
        String department = DepartmentChoiceBox1.getSelectionModel().getSelectedItem();

        // You can now use the data for your desired purpose, like saving to a database.

    }

    
}
