package org.example.model;

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

        listaPedido = getListaPedido();
        List<Repartidor> listaRepartidores = ControladorEnvios.getRepartidores();

        for (Pedido pedido : listaPedido) {
            try {
                long pausa = (long) (Math.random() * 6000);
                Thread.sleep(pausa);

                System.out.println(pedido.mostrarResumen());
                for (Repartidor repartidor : listaRepartidores){
                    if (pedido.getRepartidor().equalsIgnoreCase(repartidor.getNombre())){
                        repartidor.setLibre(true);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error al entregar su pedido");
                throw new RuntimeException(e);
            }
        }

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
