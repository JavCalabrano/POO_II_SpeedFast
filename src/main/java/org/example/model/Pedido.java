package org.example.model;

import java.util.List;

public abstract class Pedido {

    public String idPedido, tipoPedido, repartidor;
    public double distanciaKm, peso;
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
        this.peso = 0;
    }

    public Pedido(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm, double peso) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.direccion = direccion;
        this.distanciaKm = distanciaKm;
        this.estado = false;
        this.cancelado = false;
        this.repartidor = null;
        this.peso = peso;
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
                    "Su pedido fue entregado por " + repartidor + "\n" +
                    "-------------------------\n";
        }

        if (verificarCancelado()){
            return "El pedido " + idPedido + " del tipo " + tipoPedido + " fue cancelado.\n";
        }

        return "Su pedido " + idPedido + "está esperando socio repartidor para asignar su despacho\n";
    }


    // Metodos de verficacion
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

    // Metodo que transforma el objeto Pedido en el correspondiente al tipo especificado en el String.tipoPedido (creado por si se saca tipo abstracto de Pedido)
    public void tipoPedido(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            String tipo = pedido.tipoPedido;
            switch (tipo){
                case "comida":
                    Pedido comida = new PedidoComida(pedido.idPedido, pedido.tipoPedido, pedido.direccion, pedido.distanciaKm);
                    pedido=comida;
                    break;

                case "express":
                    Pedido express = new PedidoExpress(pedido.idPedido, pedido.tipoPedido, pedido.direccion, pedido.distanciaKm);
                    pedido=express;
                    break;
                case "encomienda":
                    Pedido encomienda = new PedidoEncomiendas(pedido.idPedido, pedido.tipoPedido, pedido.direccion, pedido.distanciaKm, pedido.peso);
                    pedido=encomienda;
                    break;

                default:
                    System.out.println("Tipo de pedido mal registrado");
                    break;

            }
        }
    }


    // Metodos requerimiento de proyecto
    public abstract int calcTiempoEntrega();

    public abstract String asignarRepartidor(List<Repartidor> repartidores, Pedido pedido);


    // GETTERS & SETTERS
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

