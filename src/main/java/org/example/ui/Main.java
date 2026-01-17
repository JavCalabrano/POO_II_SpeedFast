package org.example.ui;


import org.example.model.*;


public class Main {

    static void main() {

        // --- Creando objetos de Pedido para comprobar polimorfismo y sobre carga ---
        Pedido pedidoexpress = new PedidoExpress("001abc", "express",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                5.3);

        Pedido pedidoEncomienda = new PedidoEncomiendas("010abc", "encomienda",
                new Direccion("los nogales", 2563, "a30", "san bernardo", "metropolitana"),
                2.2);

        Pedido pedidoComida = new PedidoComida("100abc", "comida",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                2);


        // --- IMPRESION DE LOS PEDIDOS JUNTO CON LOS CALCULOS DE TIEMPO ---
        // **METODO calcTiemporEntrega() ES LLAMADO DIECTAMENTE EN METODO mostrarResumen()**

        System.out.println(pedidoComida.mostrarResumen());

        System.out.println(pedidoexpress.mostrarResumen());

        System.out.println(pedidoEncomienda.mostrarResumen());

    }
}
