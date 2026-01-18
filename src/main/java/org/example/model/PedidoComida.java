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
    public String asignarRepartidor(List<Repartidor> repartidores) {
        Repartidor repartidorAsignado;

        for (Repartidor repartidor : repartidores) {
                 if (repartidor.mochilaTermica && repartidor.libre) {
                     return "--- El pedido fue asignado a " + repartidor.nombre + ". ---\n";
                 }
             }

        return "No hay socios repartidores por ahora espere unos minutos\n";
    }
}
