package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Informații de conectare la baza de date
    private static final String URL = "jdbc:postgresql://localhost:5431/eliasmilosi";
    private static final String USER = "eliasmilosi";
    private static final String PASSWORD = "elias";

    private static Connection connection;

    // Metodă pentru obținerea conexiunii la baza de date
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Încarcarea driver-ului PostgreSQL
                Class.forName("org.postgresql.Driver");
                // Crearea conexiunii
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Metodă pentru închiderea conexiunii
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
