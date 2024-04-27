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
    private void btnMasuk() throws IOException {
        if (validator.validateLogin(username, password)) {
            App.setRoot("dashboard");
        }
    }

    @FXML
    private void btnKeluar() {
        System.exit(0);
    }
}