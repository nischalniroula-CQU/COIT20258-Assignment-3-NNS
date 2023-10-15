package com.hospitalmanagementsystem;

import com.hospitalmanagementsystem.model.Schedule;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewAppointmentsController {

    @FXML
    private TableView<Schedule> appointmentsTableID;
    @FXML
    private TableColumn<Schedule, String> dateID;
    @FXML
    private TableColumn<Schedule, String> timeID;
    @FXML
    private TableColumn<Schedule, String> departmentID;
    @FXML
    private TableColumn<Schedule, String> firstNameID;
    @FXML
    private TableColumn<Schedule, String> lastNameID;
    @FXML
    private TableColumn<Schedule, String> bloodGroupID;
    @FXML
    private Button cancelButton;

    public void initialize() {
        populateTableView();
    }

    private void populateTableView() {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.con;
            ObservableList<Schedule> scheduleList = FXCollections.observableArrayList();

            String query = "SELECT * FROM schedules";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(resultSet.getInt("schedule_id"));
                schedule.setFirstName(resultSet.getString("first_name"));
                schedule.setLastName(resultSet.getString("last_name"));
                schedule.setDate(resultSet.getString("date"));
                schedule.setTime(resultSet.getString("time"));
                schedule.setBloodGroup(resultSet.getString("blood_group"));
                schedule.setDepartment(resultSet.getString("department"));
                scheduleList.add(schedule);
            }

            // Set the columns to their respective properties in the Schedule model
            dateID.setCellValueFactory(new PropertyValueFactory<>("date"));
            timeID.setCellValueFactory(new PropertyValueFactory<>("time"));
            departmentID.setCellValueFactory(new PropertyValueFactory<>("department"));
            firstNameID.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameID.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            bloodGroupID.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));

            // Set the TableView items
            appointmentsTableID.setItems(scheduleList);

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
