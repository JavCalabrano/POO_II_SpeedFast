package org.example.model;

import java.util.List;

public class PedidoEncomiendas extends Pedido {

    public double peso;

    public PedidoEncomiendas(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm, double peso) {
        super(idPedido, tipoPedido = "ENCOMIENDA", direccion, distanciaKm);
        this.peso = peso;
    }

    @Override
    public int calcTiempoEntrega() {
        // se redondea el resultado final en la expresion de los minutos que entrega el calculo
        return Math.toIntExact(Math.round(20 + (1.5 * distanciaKm)));
    }

    @Override
    public String asignarRepartidor(List<Repartidor> repartidores, Pedido pedido) {
        if (pedido.getRepartidor() == null) {
            ControladorEnvios despacho = new ControladorEnvios();

            for (Repartidor repartidor : repartidores) {
                if (repartidor.transporte.equalsIgnoreCase("camioneta") && repartidor.libre) {
                    despacho.despachar(repartidor, pedido);
                    return "--- El pedido fue asignado a " + repartidor.getNombre() + ". ---\n";
                }
            }

            return "No hay socios repartidores por ahora espere unos minutos\n";
        }

        return "--- El pedido fue asignado a " + pedido.getRepartidor() + " ---\n";
    }

    public String asignarRepartidor(String nombre) {
        repartidor = nombre;
        estado = true;
        return "--- El pedido fue asignado a " + nombre + ". ---\n";
    }

}
