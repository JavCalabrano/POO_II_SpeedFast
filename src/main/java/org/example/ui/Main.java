package org.example.ui;


import org.example.model.*;

import java.sql.SQLOutput;

public class Main {

    static void main() {

        // --- Creando objetos de Pedido para comprobar polimorfismo y sobre carga ---
        Pedido pedidoexpress = new PedidoExpress("001abc", "express",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"));

        Pedido pedidoEncomienda = new PedidoEncomiendas("010abc", "encomienda",
                new Direccion("los nogales", 2563, "san bernardo", "metropolitana"));

        Pedido pedidoComida = new PedidoComida("100abc", "comida",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"));


        // Pruebas de sobreescritura
        System.out.println("PRUEBAS DE SOBREESCRITURA");
        System.out.println();
        System.out.println(pedidoexpress.asignarRepartidor());
        System.out.println(pedidoEncomienda.asignarRepartidor());
        System.out.println(pedidoComida.asignarRepartidor());
        System.out.println();


        // Pruebas de sobrecarga
        System.out.println("PRUEBAS DE SOBRECARGA");
        System.out.println(pedidoexpress.asignarRepartidor("Juanito Reyes"));
        System.out.println(pedidoComida.asignarRepartidor("Anita la huerfanita"));
        System.out.println(pedidoexpress.asignarRepartidor("Bad Bunny"));

    }
}
