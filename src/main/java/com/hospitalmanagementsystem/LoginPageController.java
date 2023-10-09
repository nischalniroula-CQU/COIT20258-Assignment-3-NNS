package com.hospitalmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;

public class LoginPageController implements Initializable {

    @FXML
    private TextField usernameId;
    @FXML
    private PasswordField passwordId;
    @FXML
    private Button loginButtonId;
    @FXML
    private Button cancelButtonId;
    
    @FXML
    private ChoiceBox<String> roleId;
    
    private ConnectionClass connectionClass;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleId.getItems().addAll("Admin", "Staff");
        roleId.getSelectionModel().selectFirst(); // Optionally select the first item by default
        connectionClass = new ConnectionClass();
        // TODO
    }    

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameId.getText();
        String password = passwordId.getText();
        String role = roleId.getSelectionModel().getSelectedItem();

        if (authenticate(username, password, role)) {
            try {
                // Load HomePage.fxml or any other page based on the role
                Parent homePage = FXMLLoader.load(getClass().getResource(getHomePageForRole(role)));
                
                Stage stage = (Stage) loginButtonId.getScene().getWindow();
                stage.setScene(new Scene(homePage));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid credentials. Please try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancelButtonAction() {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }

    /*private boolean authenticate(String username, String password, String role) {
        try {
            String query = "SELECT * FROM staffs WHERE username=? AND password=? AND role=?";
            PreparedStatement preparedStatement = connectionClass.con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
    
    
    private boolean authenticate(String username, String password, String role) {
        // Basic authentication for demonstration purposes
        if ("Admin".equals(role) && "admin".equals(username) && "admin123".equals(password)) {
            return true;
        } else if ("Staff".equals(role) && "staff".equals(username) && "staff123".equals(password)) {
            return true;
        }
        return false;
    }
    

    private String getHomePageForRole(String role) {
        // Return the appropriate FXML file based on the role
        if ("Admin".equals(role)) {
            return "AdminHomePage.fxml";
        } else if ("Staff".equals(role)) {
            return "HomePage.fxml";
        }
        return "HomePage.fxml"; // default
    }
    

}
