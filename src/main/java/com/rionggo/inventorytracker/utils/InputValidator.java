package com.rionggo.inventorytracker.utils;

public class InputValidator {

    final String adminUsername = "admin";
    final String adminPassword = "admin";

    public boolean validateLogin(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
}
