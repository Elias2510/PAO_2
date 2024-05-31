package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramareService {
    private Connection connection;

    public ProgramareService(Connection connection) {
        this.connection = connection;
    }

    public void adaugaProgramare(Programare programare) throws SQLException {
        String query = "INSERT INTO programare (id_masina, data, nume_mecanic) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, programare.getIdMasina());
            statement.setDate(2, programare.getData());
            statement.setString(3, programare.getNumeMecanic());
            statement.executeUpdate();
        }
    }

    public List<Programare> afiseazaProgramari() throws SQLException {
        List<Programare> programari = new ArrayList<>();
        String query = "SELECT * FROM programare";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idMasina = resultSet.getInt("id_masina");
                Date data = resultSet.getDate("data");
                String numeMecanic = resultSet.getString("nume_mecanic");
                programari.add(new Programare(id, idMasina, data, numeMecanic));
            }
        }
        return programari;
    }

    public void actualizeazaProgramare(Programare programare) throws SQLException {
        String query = "UPDATE programare SET id_masina = ?, data = ?, nume_mecanic = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, programare.getIdMasina());
            statement.setDate(2, programare.getData());
            statement.setString(3, programare.getNumeMecanic());
            statement.setInt(4, programare.getId());
            statement.executeUpdate();
        }
    }

    public void stergeProgramare(int idProgramare) throws SQLException {
        String query = "DELETE FROM programare WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idProgramare);
            statement.executeUpdate();
        }
    }
}
