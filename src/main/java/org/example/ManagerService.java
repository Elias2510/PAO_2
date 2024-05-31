package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {
    private Connection connection;

    public ManagerService(Connection connection) {
        this.connection = connection;
    }

    public void adaugaManager(Manager manager) throws SQLException {
        String query = "INSERT INTO manager (id_mecanic, salariu) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, manager.getIdMecanic());
            statement.setDouble(2, manager.getSalariu());
            statement.executeUpdate();
        }
    }

    public List<Manager> afiseazaManageri() throws SQLException {
        List<Manager> manageri = new ArrayList<>();
        String query = "SELECT * FROM manager";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int idPlata = resultSet.getInt("id_plata");
                int idMecanic = resultSet.getInt("id_mecanic");
                double salariu = resultSet.getDouble("salariu");
                manageri.add(new Manager(idPlata, idMecanic, salariu));
            }
        }
        return manageri;
    }

    public void actualizeazaSalariu(int idPlata, double salariuNou) throws SQLException {
        String query = "UPDATE manager SET salariu = ? WHERE id_plata = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, salariuNou);
            statement.setInt(2, idPlata);
            statement.executeUpdate();
        }
    }

    public void stergeManager(int idPlata) throws SQLException {
        String query = "DELETE FROM manager WHERE id_plata = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlata);
            statement.executeUpdate();
        }
    }
}
