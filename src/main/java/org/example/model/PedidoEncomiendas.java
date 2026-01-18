package org.example.model;

import java.util.List;

public class PedidoEncomiendas extends Pedido {

    public PedidoEncomiendas(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        super(idPedido, tipoPedido = "ENCOMIENDA", direccion, distanciaKm);
    }

    @Override
    public int calcTiempoEntrega() {
        // se redondea el resultado final en la expresion de los minutos que entrega el calculo
        return Math.toIntExact(Math.round(20 + (1.5 * distanciaKm)));
    }

    @Override
    public String asignarRepartidor(List<Repartidor> repartidores) {
        Repartidor repartidorAsignado;

        for (Repartidor repartidor : repartidores) {
            if (repartidor.transporte.equalsIgnoreCase("camioneta") && repartidor.libre) {
                return "--- El pedido fue asignado a " + repartidor.nombre + ". ---\n";
            }
        }

        return "No hay socios repartidores por ahora espere unos minutos\n";
    }
}
