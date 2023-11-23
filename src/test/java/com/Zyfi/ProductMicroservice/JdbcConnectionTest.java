package com.Zyfi.ProductMicroservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionTest {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/Orders_directory";
        String username = "springstudent";
        String password = "springstudent";

        // JDBC variables for opening, closing and managing connection
        Connection connection = null;

        try {
            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection successful!");

        } catch (SQLException e) {
            System.err.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
