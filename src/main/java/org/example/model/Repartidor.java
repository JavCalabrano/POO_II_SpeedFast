package org.example.model;

public class Repartidor {

    public String nombre, transporte;
    public boolean mochilaTermica, libre;
    public double distanciaKm;

    public Repartidor(String nombre, String transporte, boolean libre, boolean mochilaTermica, double distanciaKm) {
        this.nombre = nombre;
        this.transporte = transporte;
        this.libre = libre;
        this.mochilaTermica = mochilaTermica;
        this.distanciaKm = distanciaKm;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTransporte() {
        return transporte;
    }

    public boolean isMochilaTermica() {
        return mochilaTermica;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
