package org.example.model;

public class PedidoEncomiendas extends Pedido {

    public PedidoEncomiendas(String idPedido, String tipoPedido, Direccion direccion, double distanciaKm) {
        super(idPedido, tipoPedido = "ENCOMIENDA", direccion, distanciaKm);
    }

    @Override
    public int calcTiempoEntrega() {
        // se redondea el resultado final en la expresion de los minutos que entrega el calculo
        return Math.toIntExact(Math.round(20 + (1.5 * distanciaKm)));
    }
}
