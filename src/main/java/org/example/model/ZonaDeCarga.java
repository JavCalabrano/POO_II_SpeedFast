package org.example.model;

import org.example.util.EstadoPedido;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    public static List<Pedido> pedidos;

    public ZonaDeCarga(List<Pedido> pedidos) {
        this.pedidos = ControladorEnvios.getHistorialPedidos();
    }


    public static synchronized Pedido retirarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos");
        }

        List<Repartidor> r = ControladorEnvios.getRepartidores();

        Pedido p = pedidos.remove(0);

        p.asignarRepartidor(r, p);

        p.setEstado(EstadoPedido.EN_REPARTO);

        System.out.println("Repartidor " + p.getRepartidor() + " retiro pedido " + p.getIdPedido());
        return p;

    }

    public synchronized boolean estaVacio() {
        return  pedidos.isEmpty();
    }

}
