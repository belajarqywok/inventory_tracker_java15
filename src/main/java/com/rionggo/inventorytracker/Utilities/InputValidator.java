package com.rionggo.inventorytracker.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rionggo.inventorytracker.Configurations.DatabaseConfiguration;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InputValidator {

    public boolean validateLogin(TextField username, PasswordField password) {
        DatabaseConfiguration config = new DatabaseConfiguration();
        Connection connection = config.getConnection();
        String queryString = "SELECT * FROM login WHERE username = ? AND password = ?";
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(queryString);
                
            statement.setString(1, username.getText());
            statement.setString(2, password.getText());

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? true : false;

        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;

        } finally {
            try { if (connection != null) connection.close(); }
            catch (SQLException exception) { exception.printStackTrace(); }
        }
    }
}