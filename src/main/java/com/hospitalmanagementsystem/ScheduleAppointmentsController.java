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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;

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
    String[] times = {"09:00 AM", "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your components here

        // For example, populate timeChoiceBox
        // Populate bloodGroupChoiceBox
        bloodGroupChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

        // Populate DepartmentChoiceBox
        DepartmentChoiceBox.getItems().addAll("Cardiology", "Neurology", "Orthopedics", "Dermatology", "Emergency");
        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 1);
            }
        });
        timeChoiceBox.setDisable(true);
        DepartmentChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : null;
                if (date != null) {
                    timeChoiceBox.getItems().clear();
                    timeChoiceBox.setDisable(false);
                    String department = DepartmentChoiceBox.getItems().get((Integer) number2);
                    List<String> alreadySelectedTime = fetchTimesInDatabase(date, department);

                    List<String> newTimes = Arrays.asList(times);
                    if (alreadySelectedTime.size() != newTimes.size()) {
                        if (alreadySelectedTime != null) {
                            newTimes = newTimes.stream()
                                    .filter(element -> !alreadySelectedTime.contains(element))
                                    .collect(Collectors.toList());
                        }
                        timeChoiceBox.getItems().addAll(newTimes);
                    } else {
                        timeChoiceBox.setDisable(true);
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Time unavaible please select another date.");
                        alert.showAndWait();
                    }
                }
            }
        });

        datePicker.setOnAction(event
                -> {
            String department = DepartmentChoiceBox.getSelectionModel().getSelectedItem();
            if (department != null) {
                timeChoiceBox.setDisable(false);
            }

        });
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
        System.out.println(department);
        // You can now use the data for your desired purpose, like saving to a database or other services.

        // After the appointment has been scheduled, you might want to close the window or navigate to a different page.
        if (firstName == null || lastName == null || date == null || time == null || bloodGroup == null || department == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All field must be filled.");
            alert.showAndWait();
        } else {
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

    public List<String> fetchTimesInDatabase(String date, String department) {

        try {
            String query = "SELECT * FROM schedules WHERE date = ? AND department = ?";
            List<String> times = new ArrayList<>();
            PreparedStatement preparedStatement = connectionClass.con.prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String time = resultSet.getString("time");
                times.add(time);
            }
            return times;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}
