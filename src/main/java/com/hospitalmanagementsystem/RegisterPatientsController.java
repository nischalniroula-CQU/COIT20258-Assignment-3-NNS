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
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class RegisterPatientsController {

    // Database connection
    private ConnectionClass connectionClass = new ConnectionClass();
    
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

        try {
            String query = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, gender, blood_group, department) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectionClass.con.prepareStatement(query);
            preparedStatement.setString(1, patientID.getText());
            preparedStatement.setString(2, firstNameID.getText());
            preparedStatement.setString(3, lastNameID.getText());
            preparedStatement.setDate(4, java.sql.Date.valueOf(dobPicker.getValue()));
            preparedStatement.setString(5, genderChoiceBox.getValue());
            preparedStatement.setString(6, bloodGroupChoiceBox.getValue());
            preparedStatement.setString(7, DepartmentChoiceBox1.getValue());

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Patient registered successfully!");
                alert.showAndWait();
                cancelButtonAction(event); // Navigate back to the home page after successful registration
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to register patient. Please try again.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }

    }
