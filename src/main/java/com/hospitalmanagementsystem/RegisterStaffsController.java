package com.hospitalmanagementsystem;

import java.sql.PreparedStatement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterStaffsController {
    
    // Database connection
    private ConnectionClass connectionClass = new ConnectionClass();

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
    @FXML
    private ChoiceBox<String> staffRoleChoiceBox;

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
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void submitButtonAction() {
        
        // Example of fetching input:
        //String staffIDValue = staffID.getText();
        //System.out.println("Staff ID: " + staffIDValue);
        // Do similar for other fields and handle the submission logic.
        
        try {
            String query = "INSERT INTO staffs (staff_id, first_name, last_name, email, phone_number, address, gender, blood_group, department, date_of_birth, password, username, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectionClass.con.prepareStatement(query);
            preparedStatement.setString(1, staffID.getText());
            preparedStatement.setString(2, firstNameID.getText());
            preparedStatement.setString(3, lastNameID.getText());
            preparedStatement.setString(4, emailID.getText());
            preparedStatement.setString(5, phoneNumberID.getText());
            preparedStatement.setString(6, addressID.getText());
            preparedStatement.setString(7, genderChoiceBox.getValue());
            preparedStatement.setString(8, bloodGroupChoiceBox.getValue());
            preparedStatement.setString(9, DepartmentChoiceBox.getValue());
            preparedStatement.setDate(10, java.sql.Date.valueOf(dobPicker.getValue()));
            
            // Setting the password as a combination of phone number and staff ID
            String password = phoneNumberID.getText() + staffID.getText();
            preparedStatement.setString(11, password);
            
            // Setting the username as a combination of first name and last name
            String username = firstNameID.getText() + lastNameID.getText();
            preparedStatement.setString(12, username);
            
            preparedStatement.setString(13, staffRoleChoiceBox.getValue());

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Staff registered successfully!");
                alert.showAndWait();
                cancelButtonAction(); // Close the window after successful registration
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to register staff. Please try again.");
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

    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code (if needed)
        // For example, populate ChoiceBoxes with default values:
        genderChoiceBox.getItems().addAll("Male", "Female", "Other");
        bloodGroupChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");
        DepartmentChoiceBox.getItems().addAll("Cardiology", "Neurology", "Administration", "Radiology");
        staffRoleChoiceBox.getItems().addAll("Admin", "Staff");
    }
}
