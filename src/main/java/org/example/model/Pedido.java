package org.example.model;

public class Pedido {

    public String idPedido, tipoPedido;
    public Direccion direccion;

    public Pedido(String idPedido, String tipoPedido, Direccion direccion) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.direccion = direccion;
    }

    public String asignarRepartidor() {
        return "Se ha asignado repartidor exitosamente";
    }

    public String asignarRepartidor(String nombreRepartidor) {
        return "Se ha asignado repartidor " + nombreRepartidor + " exitosamente";
    }

}
