package org.example.model;

import org.example.interfaces.Cancelable;
import org.example.interfaces.Despachable;
import org.example.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnvios implements Cancelable, Rastreable, Despachable {

    public static List<Pedido> historialPedidos = new ArrayList<>();



    public static void agregarPedidoHistorial(Pedido pedido) {
        historialPedidos.add(pedido);
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setCancelado(true);
    }

    @Override
    public void despachar(Repartidor repartidor, Pedido pedido) {
        pedido.setRepartidor(repartidor.getNombre());
        pedido.setEstado(true);
        repartidor.setLibre(false);
    }

    @Override
    public List<Pedido> verHistorial() {
        return historialPedidos;
    }
}
