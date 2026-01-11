package org.example.model;

public class PedidoEncomiendas extends Pedido {

    public PedidoEncomiendas(String idPedido, String tipoPedido, Direccion direccion) {
        super(idPedido, tipoPedido = "ENCOMIENDA", direccion);
    }

    @Override
    public String asignarRepartidor () {

        return tipoPedido + "--- Buscando repartidor espacio para su paquete ---\n" +
                    "Se ha asignado repartidor\n";

    }

    @Override
    public String asignarRepartidor (String nombreRepartidor) {

        return tipoPedido + "--- Buscando repartidor espacio para su paquete ---\n" +
                "Se ha asignado un repartidor " + nombreRepartidor + "\n";

    }
}
