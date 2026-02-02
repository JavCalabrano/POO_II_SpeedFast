package org.example.ui;


import org.example.interfaces.Despachable;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    static void main() {

        // Objeto para llamar métodos de clase ControladorEnvios
        ControladorEnvios despacho = new ControladorEnvios();

        // --- Creando objetos de Pedido y los agrego a una lista contenida en Clase Controlador de envíos ---
        // Pedidos express
        Pedido pedidoExpress = new PedidoExpress("001abc", "express",
                new Direccion("Satelite", 3012, "Maipu", "metropolitana"),
                5.3);
        despacho.agregarPedidoHistorial(pedidoExpress);
        Pedido pedidoExpress2 = new PedidoExpress("020abd", "express",
                new Direccion("Sta. Rosa", 10666, "La Cisterna", "metropolitana"),
                6.3);
        despacho.agregarPedidoHistorial(pedidoExpress2);
        Pedido pedidoExpress3 = new PedidoExpress("030abd", "express",
                new Direccion("Departamental", 2356, "San Miguel", "metropolitana"),
                4);
        despacho.agregarPedidoHistorial(pedidoExpress3);
        Pedido pedidoExpress4 = new PedidoExpress("040abd", "express",
                new Direccion("El abrazo", 9746, "Maipu", "metropolitana"),
                5.6);
        despacho.agregarPedidoHistorial(pedidoExpress4);
        Pedido pedidoExpress5 = new PedidoExpress("020abd", "express",
                new Direccion("Caupolican", 2365, "Ranco", "Lagos"),
                11);
        despacho.agregarPedidoHistorial(pedidoExpress5);

        // Pedidos encomienda
        Pedido pedidoEncomienda = new PedidoEncomiendas("010abc", "encomienda",
                new Direccion("los nogales", 2563, "a30", "san bernardo", "metropolitana"),
                2.2, 20.3);
        despacho.agregarPedidoHistorial(pedidoEncomienda);
        Pedido pedidoEncomienda2 = new PedidoEncomiendas("131abc", "encomienda",
                new Direccion("Isidora Goyenechea", 1245, "a30", "Las condes", "Metropolitana"),
                20, 15.7);
        ControladorEnvios.agregarPedidoHistorial(pedidoEncomienda2);
        Pedido pedidoEncomienda3 = new PedidoEncomiendas("131abc", "encomienda",
                new Direccion("Entre Lagos", 303, "Osorno", "Los Lagos"),
                24, 30);
        ControladorEnvios.agregarPedidoHistorial(pedidoEncomienda3);
        Pedido pedidoEncomienda4 = new PedidoEncomiendas("131abc", "encomienda",
                new Direccion("Siempre viva", 555, "Vichulquen", "Valparaiso"),
                26.1, 23.1);
        ControladorEnvios.agregarPedidoHistorial(pedidoEncomienda4);

        // Pedidos comida
        Pedido pedidoComida = new PedidoComida("200abc", "comida",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                10);
        despacho.agregarPedidoHistorial(pedidoComida);
        Pedido pedidoComida2 = new PedidoComida("100abc", "comida",
                new Direccion("Las parcelas", 8284, "Peñalolen", "metropolitana"),
                2);
        despacho.agregarPedidoHistorial(pedidoComida2);


        // --- Creo una lista de repartidores ---
        List<Repartidor> repartidores = new ArrayList<Repartidor>();

        // --- Creando repartidores para la lista y agregarlos a la lista ---
        Repartidor moto = new Repartidor("Juanito Reyes", "Moto", true, true, 5.6);
        despacho.agregarRepartidorLista(moto);

        Repartidor auto = new Repartidor("Miguel Angel", "Auto",true, false, 2.4);
        despacho.agregarRepartidorLista(auto);

        Repartidor camioneta = new Repartidor("Ana de Armas", "Camioneta", true, false, 10);
        despacho.agregarRepartidorLista(camioneta);


        // Cancelando un pedido de forma manual
        despacho.cancelar(pedidoExpress2);


        // Asigno un repartidor de forma manuel, fuera de la lista de objetos
        System.out.println(pedidoComida2.asignarRepartidor("Javier Calabrano"));


        //Creo lista para uso de objetos almacenados
        List<Pedido> historialPedidos = despacho.verHistorial();
        List<Repartidor> listaRepartidores = despacho.getRepartidores();

        // Asignación automatica de pedidos
        for (Pedido pedido : historialPedidos) {
            pedido.asignarRepartidor(listaRepartidores, pedido);
        }

        // Imprimo historial de pedidos para revision con la entrega en consola, que verifique sea la misma cantidad y pedidos correspondientes
        for (Pedido p : historialPedidos){
            System.out.println(p.mostrarHistorial());
        }
        System.out.println(""); // salto de línea

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(moto);
        executor.submit(auto);
        executor.submit(camioneta);

        executor.shutdown();






    }
}
