package com.rionggo.inventorytracker.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.rionggo.inventorytracker.App;
import com.rionggo.inventorytracker.utils.InputValidator;

public class Login {

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Button loginButton;

    InputValidator validator = new InputValidator();

    @FXML
    private void loginToApp() throws IOException {
        if (validator.validateLogin(username.getText(), password.getText())) {
            System.out.println("login berhasil");
            App.setRoot("dashboard");
        } else {
            System.out.println("login gagal");
        }
    }

    @FXML
    private void exitApp() {
        System.exit(0);
    }
}