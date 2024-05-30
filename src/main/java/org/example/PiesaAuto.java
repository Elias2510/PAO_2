package org.example;
public class PiesaAuto {
    private int id;
    private String nume;
    private String producator;
    private double pret;

    public PiesaAuto(int id, String nume, String producator, double pret) {
        this.id = id;
        this.nume = nume;
        this.producator = producator;
        this.pret = pret;
    }

    // Getteri și Setteri
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

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "PiesaAuto{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
