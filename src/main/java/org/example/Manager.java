package org.example;

public class Manager {
    private int idPlata;
    private int idMecanic;
    private double salariu;

    public Manager(int idPlata, int idMecanic, double salariu) {
        this.idPlata = idPlata;
        this.idMecanic = idMecanic;
        this.salariu = salariu;
    }


    public int getIdPlata() {
        return idPlata;
    }

    public void setIdPlata(int idPlata) {
        this.idPlata = idPlata;
    }

    public int getIdMecanic() {
        return idMecanic;
    }

    public void setIdMecanic(int idMecanic) {
        this.idMecanic = idMecanic;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "idPlata=" + idPlata +
                ", idMecanic=" + idMecanic +
                ", salariu=" + salariu +
                '}';
    }
}
