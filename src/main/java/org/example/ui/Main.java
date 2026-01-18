package org.example.ui;


import org.example.model.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    static void main() {

        // --- Creando objetos de Pedido para comprobar polimorfismo y sobre carga ---
        Pedido pedidoExpress = new PedidoExpress("001abc", "express",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                5.3);

        Pedido pedidoEncomienda = new PedidoEncomiendas("010abc", "encomienda",
                new Direccion("los nogales", 2563, "a30", "san bernardo", "metropolitana"),
                2.2);

        Pedido pedidoComida = new PedidoComida("100abc", "comida",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                2);

        // --- Creo una lista de repartidores ---
        List<Repartidor> repartidores = new ArrayList<Repartidor>();

        // --- Creando repartidores para la lista y agregarlos a la lista ---
        Repartidor moto = new Repartidor("Juanito Reyes", "Moto", true, true, 5.6);
        repartidores.add(moto);

        // **se asigna libre (3º atributo) como false para comprobar estatus del repartidor antes de darle pedido
        Repartidor auto = new Repartidor("Miguel Angel", "Auto",false, false, 2.4);
        repartidores.add(auto);

        Repartidor camioneta = new Repartidor("Ana de Armas", "Camioneta", true, false, 10);
        repartidores.add(camioneta);


        // --- IMPRESION DE LOS PEDIDOS JUNTO CON LOS CALCULOS DE TIEMPO ---
        // **METODO calcTiemporEntrega() ES LLAMADO DIECTAMENTE EN METODO mostrarResumen()**

        System.out.println(pedidoComida.mostrarResumen());
        System.out.println(pedidoComida.asignarRepartidor(repartidores));

        System.out.println(pedidoExpress.mostrarResumen());
        System.out.println(pedidoExpress.asignarRepartidor(repartidores));

        System.out.println(pedidoEncomienda.mostrarResumen());
        System.out.println(pedidoEncomienda.asignarRepartidor(repartidores));

    }
}
