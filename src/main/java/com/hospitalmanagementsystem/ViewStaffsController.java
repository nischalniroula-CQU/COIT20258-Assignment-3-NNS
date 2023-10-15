package com.hospitalmanagementsystem;

import com.hospitalmanagementsystem.model.Staff;
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


public class ViewStaffsController {

    @FXML
    private Button cancelButton;
    
    @FXML
    private Button editButtonID;

    @FXML
    private TextArea staffID;  
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
    private TextArea phoneNumberID;
    @FXML
    private TextArea emailID;
    @FXML
    private TextArea addressID;
    @FXML
    private TextArea roleID;

    @FXML
    public void initialize() {
        makeTextAreasNonEditable();
    }

    private void makeTextAreasNonEditable() {
        staffID.setEditable(false);
        firstNameID.setEditable(false);
        lastNameID.setEditable(false);
        dobID.setEditable(false);
        genderID.setEditable(false);
        bloodGroupID.setEditable(false);
        departmentID.setEditable(false);
        phoneNumberID.setEditable(false);
        emailID.setEditable(false);
        addressID.setEditable(false);
        roleID.setEditable(false);
    }

    @FXML
    private void cancelButtonAction() {
        try {
        // Get the current stage using the cancel button
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        // Close the stage
        stage.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    @FXML
    private void editButtonAction(){
        if ("Edit".equals(editButtonID.getText())){
            toggleTextAreasEditable();
            editButtonID.setText("Save");
        } else {
            saveEditedDetailsToDatabase();
            toggleTextAreasEditable();
            editButtonID.setText("Edit");
        }
        
    }

    public void setStaffDetails(Staff staff) {
        staffID.setText(staff.getStaffID());
        firstNameID.setText(staff.getFirstName());
        lastNameID.setText(staff.getLastName());
        dobID.setText(staff.getDateOfBirth());
        genderID.setText(staff.getGender());
        bloodGroupID.setText(staff.getBloodGroup());
        departmentID.setText(staff.getDepartment());
        phoneNumberID.setText(staff.getPhoneNumber());
        emailID.setText(staff.getEmail());
        addressID.setText(staff.getAddress());
        roleID.setText(staff.getRole());
    }
    
    private void toggleTextAreasEditable(){
        boolean isEditable = staffID.isEditable();
        staffID.setEditable(!isEditable);
        firstNameID.setEditable(!isEditable);
        lastNameID.setEditable(!isEditable);
        dobID.setEditable(!isEditable);
        genderID.setEditable(!isEditable);
        bloodGroupID.setEditable(!isEditable);
        departmentID.setEditable(!isEditable);
        phoneNumberID.setEditable(!isEditable);
        emailID.setEditable(!isEditable);
        addressID.setEditable(!isEditable);
        roleID.setEditable(!isEditable);
    }
    
    private void saveEditedDetailsToDatabase() {
    // Retrieve edited details from text areas
    String staffIDValue = staffID.getText();
    String firstNameValue = firstNameID.getText();
    String lastNameValue = lastNameID.getText();
    String dobValue = dobID.getText();
    String genderValue = genderID.getText();
    String bloodGroupValue = bloodGroupID.getText();
    String departmentValue = departmentID.getText();
    String phoneNumberValue = phoneNumberID.getText();
    String emailValue = emailID.getText();
    String addressValue = addressID.getText();
    String roleValue = roleID.getText();
    String updatedPassword = phoneNumberID.getText() + staffID.getText();
    String updatedUsername = firstNameValue + lastNameValue;

    // Use prepared statements to update the database
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.con;
    String sql = "UPDATE staffs SET first_name = ?, last_name = ?, email = ?, phone_number = ?, address = ?, gender = ?, blood_group = ?, department = ?, date_of_birth = ?, role = ?, username = ?, password = ? WHERE staff_id = ?";

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstNameValue);
        preparedStatement.setString(2, lastNameValue);
        preparedStatement.setString(3, emailValue);
        preparedStatement.setString(4, phoneNumberValue);
        preparedStatement.setString(5, addressValue);
        preparedStatement.setString(6, genderValue);
        preparedStatement.setString(7, bloodGroupValue);
        preparedStatement.setString(8, departmentValue);
        preparedStatement.setString(9, dobValue);
        preparedStatement.setString(10, roleValue);
        preparedStatement.setString(11, updatedUsername);
        preparedStatement.setString(12, updatedPassword);
        preparedStatement.setString(13, staffIDValue);

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
            alert.setContentText("Staff details were updated successfully.");
            alert.showAndWait();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exceptions more gracefully, maybe display a user-friendly message or log the error.
    }
}

    
    

    // You might want to add a method to retrieve the staff details from the database using the staffID
    public Staff getStaffDetailsFromDatabase(String staffID) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.con;
        String sql = "SELECT * FROM staffs WHERE staff_id = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staffID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getString("staff_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("gender"),
                        resultSet.getString("blood_group"),
                        resultSet.getString("department"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("role")
                );
                return staff;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
