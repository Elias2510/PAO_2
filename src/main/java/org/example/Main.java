package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        testConnection();
    }

    public static void testConnection() {
        Connection connection = null;
        try {
            // Obține conexiunea la baza de date
            connection = DatabaseConnection.getConnection();
            System.out.println("Conexiunea la baza de date a fost stabilită cu succes!");
            // Aici poți adăuga alte operații care folosesc conexiunea la baza de date
        } finally {
            // Închide conexiunea
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Eroare la închiderea conexiunii: " + e.getMessage());
                }
            }
        }
    }
}