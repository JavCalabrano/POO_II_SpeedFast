package org.example.model;

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


}
