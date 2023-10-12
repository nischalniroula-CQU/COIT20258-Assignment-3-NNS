package com.hospitalmanagementsystem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ViewPatientsController {

    @FXML
    private Button cancelButton;
    
    @FXML
    private Button editButtonID;

    @FXML
    private TextArea patientID;  
    @FXML
    private TextArea firstNameID;
    @FXML
    private TextArea lastNameID;
    @FXML
    private TextArea dobID;
    @FXML
    private TextArea genderID;
    @FXML
    private TextArea bloodGroupID;
    @FXML
    private TextArea departmentID;
    @FXML
    private TextArea heightID;
    @FXML
    private TextArea weightID;
    @FXML
    private TextArea bloodPressureID;
    @FXML
    private TextArea bmiID;

    @FXML
    public void initialize() {
        makeTextAreasNonEditable();
    }

    private void makeTextAreasNonEditable() {
        patientID.setEditable(false);
        firstNameID.setEditable(false);
        lastNameID.setEditable(false);
        dobID.setEditable(false);
        genderID.setEditable(false);
        bloodGroupID.setEditable(false);
        departmentID.setEditable(false);
        heightID.setEditable(false);
        weightID.setEditable(false);
        bloodPressureID.setEditable(false);
        bmiID.setEditable(false);
    }

    @FXML
    private void cancelButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent homePage = loader.load();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(homePage));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void editButtonAction() {
        if ("Edit".equals(editButtonID.getText())) {
            toggleTextAreasEditable();
            editButtonID.setText("Save");
        } else {
            saveEditedDetailsToDatabase();
            toggleTextAreasEditable();
            editButtonID.setText("Edit");
        }
    }

    public void setPatientDetails(Patient patient) {
        patientID.setText(patient.getPatientID());
        firstNameID.setText(patient.getFirstName());
        lastNameID.setText(patient.getLastName());
        dobID.setText(patient.getDateOfBirth());
        genderID.setText(patient.getGender());
        bloodGroupID.setText(patient.getBloodGroup());
        departmentID.setText(patient.getDepartment());
        heightID.setText(String.valueOf(patient.getHeight()));
        weightID.setText(String.valueOf(patient.getWeight()));
        bloodPressureID.setText(patient.getBloodPressure());
        bmiID.setText(String.valueOf(patient.getBmi()));
    }

    private void toggleTextAreasEditable() {
        boolean isEditable = patientID.isEditable();
        patientID.setEditable(!isEditable);
        firstNameID.setEditable(!isEditable);
        lastNameID.setEditable(!isEditable);
        dobID.setEditable(!isEditable);
        genderID.setEditable(!isEditable);
        bloodGroupID.setEditable(!isEditable);
        departmentID.setEditable(!isEditable);
        heightID.setEditable(!isEditable);
        weightID.setEditable(!isEditable);
        bloodPressureID.setEditable(!isEditable);
        bmiID.setEditable(!isEditable);
    }

    private void saveEditedDetailsToDatabase() {
    // Retrieve edited details from text areas
    String patientIDValue = patientID.getText();
    String firstNameValue = firstNameID.getText();
    String lastNameValue = lastNameID.getText();
    String dobValue = dobID.getText();
    String genderValue = genderID.getText();
    String bloodGroupValue = bloodGroupID.getText();
    String departmentValue = departmentID.getText();
    String heightValue = heightID.getText();
    String weightValue = weightID.getText();
    String bloodPressureValue = bloodPressureID.getText();
    String bmiValue = bmiID.getText();

    // Use prepared statements to update the database
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.con;
    String sql = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, blood_group = ?, department = ?, height = ?, weight = ?, blood_pressure = ?, bmi = ? WHERE patient_id = ?";

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstNameValue);
        preparedStatement.setString(2, lastNameValue);
        preparedStatement.setDate(3, java.sql.Date.valueOf(dobValue)); // assuming dobValue is in format "YYYY-MM-DD"
        preparedStatement.setString(4, genderValue);
        preparedStatement.setString(5, bloodGroupValue);
        preparedStatement.setString(6, departmentValue);
        preparedStatement.setDouble(7, Double.parseDouble(heightValue)); // parsing as Double
        preparedStatement.setBigDecimal(8, new BigDecimal(weightValue)); // using BigDecimal
        preparedStatement.setString(9, bloodPressureValue);
        preparedStatement.setBigDecimal(10, new BigDecimal(bmiValue)); // using BigDecimal
        preparedStatement.setString(11, patientIDValue);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            // Handle situation where no rows were updated
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No changes were made.");
            alert.showAndWait();
        } else {
            // Notify the user of a successful update
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Patient details were updated successfully.");
            alert.showAndWait();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exceptions more gracefully, maybe display a user-friendly message or log the error.
    }
}


    public Patient getPatientDetailsFromDatabase(String patientID) {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.con;
    String sql = "SELECT * FROM patients WHERE patient_id = ?";
    
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, patientID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Patient patient = new Patient(
                    resultSet.getString("patient_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("date_of_birth").toLocalDate().toString(),
                    resultSet.getString("gender"),
                    resultSet.getString("blood_group"),
                    resultSet.getString("department"),
                    resultSet.getDouble("height"),
                    resultSet.getBigDecimal("weight").doubleValue(), 
                    resultSet.getString("blood_pressure"),
                    resultSet.getBigDecimal("bmi").doubleValue() 
            );
            return patient;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}
