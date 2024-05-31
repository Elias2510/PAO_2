package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocatieService {
    private Connection connection;

    public LocatieService(Connection connection) {
        this.connection = connection;
    }

    public void adaugaLocatie(Locatie locatie) throws SQLException {
        String query = "INSERT INTO locatie (judet, oras, mecanic_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, locatie.getJudet());
            statement.setString(2, locatie.getOras());
            statement.setInt(3, locatie.getMecanicId());
            statement.executeUpdate();
        }
    }

    public List<Locatie> afiseazaLocatii() throws SQLException {
        List<Locatie> locatii = new ArrayList<>();
        String query = "SELECT * FROM locatie";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String judet = resultSet.getString("judet");
                String oras = resultSet.getString("oras");
                int mecanicId = resultSet.getInt("mecanic_id");
                locatii.add(new Locatie(id, judet, oras, mecanicId));
            }
        }
        return locatii;
    }

    public void actualizeazaLocatie(Locatie locatie) throws SQLException {
        String query = "UPDATE locatie SET judet = ?, oras = ?, mecanic_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, locatie.getJudet());
            statement.setString(2, locatie.getOras());
            statement.setInt(3, locatie.getMecanicId());
            statement.setInt(4, locatie.getId());
            statement.executeUpdate();
        }
    }

    public void stergeLocatie(int idLocatie) throws SQLException {
        String query = "DELETE FROM locatie WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idLocatie);
            statement.executeUpdate();
        }
    }

}
