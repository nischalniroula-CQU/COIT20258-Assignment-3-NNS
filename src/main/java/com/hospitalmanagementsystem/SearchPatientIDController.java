package com.hospitalmanagementsystem;

import com.hospitalmanagementsystem.model.Patient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SearchPatientIDController {

    @FXML
    private TextField patientID;

    @FXML
    private Button cancelButtonID;

    @FXML
    private Button searchButtonID;
    
    private ConnectionClass connectionClass = new ConnectionClass();
    private Connection connection = connectionClass.con;

    @FXML
    public void initialize() {
        // Initialization logic, if needed
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
    Stage stage = (Stage) cancelButtonID.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        String id = patientID.getText().trim();
        Patient patient = getPatientDetailsByID(id);
        
         if (patient == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Patient ID or Patient not found!");
            alert.showAndWait();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewPatients.fxml"));
                Parent root = loader.load();
                
                ViewPatientsController controller = loader.getController();
                controller.setPatientDetails(patient);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) cancelButtonID.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }
    
    private Patient getPatientDetailsByID(String id) {
    try {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String patientID = resultSet.getString("patient_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String dateOfBirth = resultSet.getString("date_of_birth");
            String gender = resultSet.getString("gender");
            String bloodGroup = resultSet.getString("blood_group");
            String department = resultSet.getString("department");
            double height = resultSet.getDouble("height");
            double weight = resultSet.getDouble("weight");
            String bloodPressure = resultSet.getString("blood_pressure");
            double bmi = resultSet.getDouble("bmi");
            String reason = resultSet.getString("reason");

            return new Patient(patientID, firstName, lastName, dateOfBirth, gender, bloodGroup, department, height, weight, bloodPressure, bmi, reason);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }


    // Additional methods or logic can be added as required.
}
