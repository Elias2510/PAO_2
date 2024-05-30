package org.example;

import java.util.Date;

public class Masina {

    private int id;
    private String marca;
    private String model;
    private int anFabricatie;

    public Masina(int id, String marca, String model, int anFabricatie) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
    }
    // Constructor fără parametrul id
    public Masina(String marca, String model, int anFabricatie) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", anFabricatie=" + anFabricatie +
                '}';
    }
}
