package org.example;

public class Locatie {
    private int id;
    private String judet;
    private String oras;
    private int mecanicId;

    public Locatie(int id, String judet, String oras, int mecanicId) {
        this.id = id;
        this.judet = judet;
        this.oras = oras;
        this.mecanicId = mecanicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public int getMecanicId() {
        return mecanicId;
    }

    public void setMecanicId(int mecanicId) {
        this.mecanicId = mecanicId;
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "id=" + id +
                ", judet='" + judet + '\'' +
                ", oras='" + oras + '\'' +
                ", mecanicId=" + mecanicId +
                '}';
    }
}
