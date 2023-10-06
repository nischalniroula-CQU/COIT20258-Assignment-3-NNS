/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.hospitalmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author nischalniroula
 */
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
    private ChoiceBox<?> roleId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
