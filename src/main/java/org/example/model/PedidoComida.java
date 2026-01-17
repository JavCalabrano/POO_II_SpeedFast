package org.example.model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        super(idPedido, tipoPedido = "COMIDA", direccion, distanciaKm);
    }

    @Override
    public int calcTiempoEntrega() {
        // se trunca la distancia en los Km enteros para usar en el calculo evitando
        return (15 + (2 * (int)distanciaKm));
    }
}
