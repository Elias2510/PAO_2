package org.example;

class MasinaElectrica extends Masina {
    private int autonomie;

    public MasinaElectrica(int id,String marca, String model, int anFabricatie, int autonomie) {
        super(id,marca, model, anFabricatie);
        this.autonomie = autonomie;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    @Override
    public String toString() {
        return "MasinaElectrica{" +
                "marca='" + getMarca() + '\'' +
                ", model='" + getModel() + '\'' +
                ", anFabricatie=" + getAnFabricatie() +
                ", autonomie=" + autonomie +
                '}';
    }
}
