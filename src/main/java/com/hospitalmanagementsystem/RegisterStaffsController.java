package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegisterStaffsController {

    // TextFields
    @FXML
    private TextField staffID;
    @FXML
    private TextField firstNameID;
    @FXML
    private TextField lastNameID;
    @FXML
    private TextField emailID;
    @FXML
    private TextField phoneNumberID;
    @FXML
    private TextField addressID;

    // ChoiceBoxes
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private ChoiceBox<String> bloodGroupChoiceBox;
    @FXML
    private ChoiceBox<String> DepartmentChoiceBox;

    // DatePicker
    @FXML
    private DatePicker dobPicker;

    // Buttons
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;

    // Methods handling the button actions
    @FXML
    private void cancelButtonAction() {
        // Code to handle cancel action
        System.out.println("Cancel clicked.");
    }

    @FXML
    private void submitButtonAction() {
        // Code to handle submit action
        System.out.println("Submit clicked.");

        // Example of fetching input:
        String staffIDValue = staffID.getText();
        System.out.println("Staff ID: " + staffIDValue);

        // Do similar for other fields and handle the submission logic.
    }

    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code (if needed)
        // For example, populate ChoiceBoxes with default values:
        genderChoiceBox.getItems().addAll("Male", "Female", "Other");
        bloodGroupChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");
        DepartmentChoiceBox.getItems().addAll("Cardiology", "Neurology", "Administration", "Radiology");
    }
}
