package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasinaService {
    private Connection connection;



    public void adaugaMasina(Masina masina) throws SQLException {
        String query = "INSERT INTO masina (marca, model, an_fabricatie) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, masina.getMarca());
            statement.setString(2, masina.getModel());
            statement.setInt(3, masina.getAnFabricatie());
            statement.executeUpdate();
        }
    }

    public List<Masina> afiseazaMasini() throws SQLException {
        List<Masina> masini = new ArrayList<>();
        String query = "SELECT * FROM masina";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String marca = resultSet.getString("marca");
                String model = resultSet.getString("model");
                int anFabricatie = resultSet.getInt("an_fabricatie");
                masini.add(new Masina(id, marca, model, anFabricatie));
            }
        }
        return masini;
    }

    public void actualizeazaMasina(Masina masina) throws SQLException {
        String query = "UPDATE masina SET marca = ?, model = ?, an_fabricatie = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, masina.getMarca());
            statement.setString(2, masina.getModel());
            statement.setInt(3, masina.getAnFabricatie());
            statement.setInt(4, masina.getId());
            statement.executeUpdate();
        }
    }

    public void stergeMasina(int idMasina) throws SQLException {
        String query = "DELETE FROM masina WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMasina);
            statement.executeUpdate();
        }
    }

}