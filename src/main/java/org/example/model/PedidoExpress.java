package org.example.model;

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
