package org.example.model;

import java.util.List;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        super(idPedido, tipoPedido = "COMIDA", direccion, distanciaKm);
    }

    @Override
    public int calcTiempoEntrega() {
        // se trunca la distancia en los Km enteros para usar en el calculo evitando
        return (15 + (2 * (int)distanciaKm));
    }

    @Override
    public String asignarRepartidor(List<Repartidor> repartidores, Pedido pedido) {

        ControladorEnvios despacho = new ControladorEnvios();

        if (pedido.getRepartidor() == null) {

            for (Repartidor repartidor : repartidores) {
                if (repartidor.mochilaTermica && repartidor.libre) {
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

        despacho.despachar(new Repartidor(pedido.getRepartidor(), "auto", false, true, 5.2), pedido);

        return "--- El pedido fue asignado a " + pedido.getRepartidor() + " ---\n";
    }

    public String asignarRepartidor(String nombre) {

        repartidor = nombre;
        setEstado(true);

        return "--- El pedido " + idPedido + " tipo " + tipoPedido + " fue asignado a " + nombre + ". ---\n";
    }
}
