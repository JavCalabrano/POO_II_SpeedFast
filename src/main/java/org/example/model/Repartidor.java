package org.example.model;

import org.example.util.EstadoPedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repartidor implements Runnable {

    public String nombre, transporte;
    public boolean mochilaTermica, libre;
    public double distanciaKm;
    public List<Pedido> listaPedido;

    public Repartidor(String nombre, String transporte, boolean libre, boolean mochilaTermica, double distanciaKm) {
        this.nombre = nombre;
        this.transporte = transporte;
        this.libre = libre;
        this.mochilaTermica = mochilaTermica;
        this.distanciaKm = distanciaKm;
        this.listaPedido = new ArrayList<>();
    }


    // Metodo Runnable
    public void run() {

        boolean ciclo = true;
        do {

            Pedido pedido = ZonaDeCarga.retirarPedidos();

            if (pedido == null) {
                System.out.println("Todos los pedidos han sido entregados. Cerrando el chiringuito");
                ciclo = false;
            }

            try {

                Thread.sleep(2000 + (int)(Math.random() * 3000));
                pedido.setEstado(EstadoPedido.DESPACHADO);
                System.out.println(pedido.mostrarHistorial());

            } catch (InterruptedException e) {
                System.out.println("Simulacion de entrega interrumpida");
                throw new RuntimeException(e);
            }


        }while (ciclo);




    }


    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public String getTransporte() {
        return transporte;
    }

    public boolean isMochilaTermica() {
        return mochilaTermica;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public List<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(Pedido pedido) {
        listaPedido.add(pedido);
    }
}
