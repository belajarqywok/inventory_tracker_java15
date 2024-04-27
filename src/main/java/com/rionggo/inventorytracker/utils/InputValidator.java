package com.rionggo.inventorytracker.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rionggo.inventorytracker.connection.MySQLConnection;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InputValidator {

    public boolean validateLogin(TextField username, PasswordField password) {
        MySQLConnection connection = new MySQLConnection();
        Connection conn = connection.getConnection();
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username.getText());
            stmt.setString(2, password.getText());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}