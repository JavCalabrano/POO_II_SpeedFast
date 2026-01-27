package org.example.model;

import java.util.List;

public abstract class Pedido {

    public String idPedido, tipoPedido, repartidor;
    public double distanciaKm;
    public Direccion direccion;
    public boolean estado, cancelado;

    public Pedido(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.direccion = direccion;
        this.distanciaKm = distanciaKm;
        this.estado = false;
        this.cancelado = false;
        this.repartidor = null;
    }


    public String mostrarHistorial() {
        return "El pedido " + idPedido + " tipo " + tipoPedido + " fue " + (cancelado ? "cancelado" : estado ? "entregado por " + repartidor : "esperando repartidor");
    }


    // === SE LLAMA AL METODO DE calcTiempoEntrega() PARA INCLUIR EN RESUMEN
    public String mostrarResumen () {

        if (verificarEstado()){
            return "Su pedido tipo " + tipoPedido + " nro:" + idPedido + " a sido ingresado.\n" +
                    "Direccion: " + direccion + "\n" +
                    "Distancia: " + distanciaKm + " km\n" +
                    "Tiempo estimado de entrega: " + calcTiempoEntrega() + " minutos\n" +
                    "Despachado correctamente por " + repartidor + "\n";
        }

        if (verificarCancelado()){
            return "El pedido " + idPedido + " del tipo " + tipoPedido + " fue cancelado.\n";
        }

        return "Su pedido " + idPedido + "está esperando socio repartidor para asignar su despacho\n";
    }

    public boolean verificarEstado(){
        if (estado){
            return true;
        }
        return false;
    }

    public boolean verificarCancelado(){
        if (cancelado){
            return true;
        }
        return false;
    }

    public abstract int calcTiempoEntrega();

    public abstract String asignarRepartidor(List<Repartidor> repartidores, Pedido pedido);

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public String asignarRepartidor(String nombre) {
        return null;
    }
}

