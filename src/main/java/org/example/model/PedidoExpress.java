package org.example.model;

public class PedidoExpress extends Pedido{

    public PedidoExpress(String idPedido, String tipoPedido, Direccion direccion) {
        super(idPedido, tipoPedido = "EXPRESS", direccion);
    }

    @Override
    public String asignarRepartidor () {

        return tipoPedido + "--- Buscando repartidor más cercano ---\n" +
                    "Se ha asignado a repartidor\n";

    }

    @Override
    public String asignarRepartidor (String nombreRepartidor) {

        return tipoPedido + "--- Buscando repartidor más cercano ---\n" +
                "Se ha asignado a repartidor " + nombreRepartidor + "\n";

    }
}
