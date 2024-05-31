package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MecanicService {
    private Connection connection;

    public MecanicService(Connection connection) {
        this.connection = connection;
    }

    public void adaugaMecanic(Mecanic mecanic) throws SQLException {
        String query = "INSERT INTO mecanic (nume, specializare) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, mecanic.getNume());
            statement.setString(2, mecanic.getSpecializare());
            statement.executeUpdate();
        }
    }

    public List<Mecanic> afiseazaMecanici() throws SQLException {
        List<Mecanic> mecanici = new ArrayList<>();
        String query = "SELECT * FROM mecanic";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String specializare = resultSet.getString("specializare");
                mecanici.add(new Mecanic(id, nume, specializare));
            }
        }
        return mecanici;
    }

    public void actualizeazaMecanic(Mecanic mecanic) throws SQLException {
        String query = "UPDATE mecanic SET nume = ?, specializare = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, mecanic.getNume());
            statement.setString(2, mecanic.getSpecializare());
            statement.setInt(3, mecanic.getId());
            statement.executeUpdate();
        }
    }

    public void stergeMecanic(int idMecanic) throws SQLException {
        String query = "DELETE FROM mecanic WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMecanic);
            statement.executeUpdate();
        }
    }
}
