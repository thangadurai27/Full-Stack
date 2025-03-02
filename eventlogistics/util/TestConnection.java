package com.eventlogistics.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/logistics_management"; // Your DB URL
        String user = "root"; // Your DB 
        String password = "W7301@jqir#"; // Your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
