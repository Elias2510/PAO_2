package org.example;

public class Mecanic {
    private int id;
    private String nume;
    private String specializare;

    public Mecanic(int id, String nume, String specializare) {
        this.id = id;
        this.nume = nume;
        this.specializare = specializare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
}
