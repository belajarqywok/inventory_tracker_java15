package com.rionggo.inventorytracker.Handlers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.rionggo.inventorytracker.App;
import com.rionggo.inventorytracker.Repositories.AuthRepositories;

public class LoginHandlers extends AuthRepositories {

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Button loginButton;

    @FXML
    private void btnMasuk() throws IOException {
        boolean validation = loginRepo(
            username.getText(), password.getText());

        if (validation) App.setRoot("dashboard");
    }

    @FXML
    private void btnKeluar() {
        System.exit(0);
    }
}