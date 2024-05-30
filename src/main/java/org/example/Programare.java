package org.example;

import java.util.Date;

public class Programare {
    private int id;
    private int idMasina;
    private Date data;
    private String numeMecanic;

    public Programare(int id, int idMasina, Date data, String numeMecanic) {
        this.id = id;
        this.idMasina = idMasina;
        this.data = data;
        this.numeMecanic = numeMecanic;
    }

    // Getteri și Setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNumeMecanic() {
        return numeMecanic;
    }

    public void setNumeMecanic(String numeMecanic) {
        this.numeMecanic = numeMecanic;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", idMasina=" + idMasina +
                ", data=" + data +
                ", numeMecanic='" + numeMecanic + '\'' +
                '}';
    }
}
