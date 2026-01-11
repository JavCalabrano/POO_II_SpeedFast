package org.example.model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String tipoPedido, Direccion direccion) {
        super(idPedido, tipoPedido = "COMIDA", direccion);
    }

    @Override
    public String asignarRepartidor () {

        return tipoPedido + "--- Buscando repartidor con mochila termina ---\n" +
                    "Se ha asignado un repartidor\n";

    }

    @Override
    public String asignarRepartidor (String nombreRepartidor) {

        return tipoPedido + "--- Buscando repartidor con mochila termina ---\n" +
                "Se ha asignado un repartidor " + nombreRepartidor + "\n";

    }

}
