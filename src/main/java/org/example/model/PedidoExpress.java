package org.example.model;

import org.example.util.EstadoPedido;

import java.util.List;

public class PedidoExpress extends Pedido{

    public PedidoExpress(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        super(idPedido, tipoPedido = "EXPRESS", direccion, distanciaKm);
    }

    @Override
    public int calcTiempoEntrega() {
        // se crea la variable para almacenar la condicion y sumar
        int extra = (distanciaKm > 5) ? 5 : 0;
        return 10 + extra;
    }

    @Override
    public String asignarRepartidor(List<Repartidor> repartidores, Pedido pedido) {

        if (pedido.getRepartidor() == null) {
            ControladorEnvios despacho = new ControladorEnvios();

            for (Repartidor repartidor : repartidores) {
                if (repartidor.transporte.equalsIgnoreCase("auto") && repartidor.libre) {
                    pedido.setRepartidor(repartidor.getNombre());
                    repartidor.setListaPedido(pedido);
                    despacho.despachar(repartidor, pedido);

                    // Set de libre para simulacion de hilos
                    repartidor.setLibre(true);
                    return "--- El pedido fue asignado a " + repartidor.getNombre() + ". ---\n";
                }
            }

            return "No hay socios repartidores por ahora espere unos minutos\n";
        }

        return "--- El pedido fue asignado a " + pedido.getRepartidor() + " ---\n";
    }

    public String asignarRepartidor(String nombre) {
        repartidor = nombre;
        estado = EstadoPedido.EN_REPARTO;
        return "--- El pedido fue asignado a " + nombre + ". ---\n";
    }

}
