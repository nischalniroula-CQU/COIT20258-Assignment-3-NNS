package com.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchStaffIDController {

    @FXML
    private Button cancelButtonID;
    @FXML
    private TextField staffID;
    @FXML
    private Button searchButtonID;

    private ConnectionClass connectionClass = new ConnectionClass();
    private Connection connection = connectionClass.con;

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButtonID.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        String id = staffID.getText().trim();
        Staff staff = getStaffDetailsByID(id);

        if (staff == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Staff ID or Staff not found!");
            alert.showAndWait();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewStaffs.fxml"));
                Parent root = loader.load();
                
                ViewStaffsController controller = loader.getController();
                controller.setStaffDetails(staff);

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

    private Staff getStaffDetailsByID(String id) {
        try {
            String sql = "SELECT * FROM staffs WHERE staff_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String staffID = resultSet.getString("staff_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                String bloodGroup = resultSet.getString("blood_group");
                String department = resultSet.getString("department");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String role = resultSet.getString("role");

                return new Staff(staffID, firstName, lastName, email, phoneNumber, address, gender, bloodGroup, department, dateOfBirth, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
