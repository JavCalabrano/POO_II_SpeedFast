package org.example.model;

public class Repartidor {

    private int id;
    private String nombre;


    public Repartidor() {
    }
    public Repartidor( String nombre) {
        this.nombre = nombre;
    }

    public Repartidor( int id) {
        this.id = id;
    }

    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
}
