package com.hospitalmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;

public class ScheduleAppointmentsController implements Initializable {

    @FXML
    private TextField firstNameID;

    @FXML
    private TextField lastNameID;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> timeChoiceBox;

    @FXML
    private ChoiceBox<String> bloodGroupChoiceBox;

    @FXML
    private ChoiceBox<String> DepartmentChoiceBox;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;
    
    // Database connection
    private ConnectionClass connectionClass = new ConnectionClass();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your components here

        // For example, populate timeChoiceBox
        timeChoiceBox.getItems().addAll("09:00 AM", "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM");

        // Populate bloodGroupChoiceBox
        bloodGroupChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

        // Populate DepartmentChoiceBox
        DepartmentChoiceBox.getItems().addAll("Cardiology", "Neurology", "Orthopedics", "Dermatology", "Emergency");
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
    private void submitButtonAction() {
        // Handle the submission logic here

        String firstName = firstNameID.getText();
        String lastName = lastNameID.getText();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : null;
        String time = timeChoiceBox.getSelectionModel().getSelectedItem();
        String bloodGroup = bloodGroupChoiceBox.getSelectionModel().getSelectedItem();
        String department = DepartmentChoiceBox.getSelectionModel().getSelectedItem();

        // You can now use the data for your desired purpose, like saving to a database or other services.

        // After the appointment has been scheduled, you might want to close the window or navigate to a different page.
        
        try {
            String query = "INSERT INTO schedules (first_name, last_name, date, time, blood_group, department) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectionClass.con.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, time);
            preparedStatement.setString(5, bloodGroup);
            preparedStatement.setString(6, department);

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Schedule appointment  successfully!");
                alert.showAndWait();
                cancelButtonAction(); // Close the window after successful registration
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to schedule appointment. Please try again using different time.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
