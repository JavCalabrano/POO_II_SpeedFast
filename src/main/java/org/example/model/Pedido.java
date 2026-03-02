package org.example.model;

public class Pedido {

    private int id;
    private String direccion, tipo, estado;

    public Pedido(int id, String direccion, String tipo, String estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }


}
