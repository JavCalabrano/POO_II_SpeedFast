package org.example.model;

import java.util.List;

public abstract class Pedido {

    public String idPedido, tipoPedido;
    public double distanciaKm;
    public Direccion direccion;

    public Pedido(String idPedido, String tipoPedido, Direccion direccion, double  distanciaKm) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.direccion = direccion;
        this.distanciaKm = distanciaKm;
    }

    // === SE LLAMA AL METODO DE calcTiempoEntrega() PARA INCLUIR EN RESUMEN

    public String mostrarResumen () {
        return "Su " + tipoPedido + " nro:" + idPedido + " a sido ingresado.\n" +
                "Direccion: " + direccion + "\n" +
                "Distancia: " + distanciaKm + " km\n" +
                "Tiempo estimado de entrega: " + calcTiempoEntrega() + "\n";
    }

    public abstract int calcTiempoEntrega();

    public abstract String asignarRepartidor(List<Repartidor> repartidores);
}
