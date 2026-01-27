package org.example.ui;


import org.example.interfaces.Despachable;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;


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

        // Pedidos encomienda
        Pedido pedidoEncomienda = new PedidoEncomiendas("010abc", "encomienda",
                new Direccion("los nogales", 2563, "a30", "san bernardo", "metropolitana"),
                2.2, 20.3);
        despacho.agregarPedidoHistorial(pedidoEncomienda);
        Pedido pedidoEncomienda2 = new PedidoEncomiendas("131abc", "comida",
                new Direccion("Isidora Goyenechea", 1245, "a30", "Las condes", "Metropolitana"),
                20, 15.7);
        ControladorEnvios.agregarPedidoHistorial(pedidoEncomienda2);

        // Pedidos comida
        Pedido pedidoComida = new PedidoComida("200abc", "comida",
                new Direccion("las acacias", 2758, "la pintana", "metropolitana"),
                2);
        despacho.agregarPedidoHistorial(pedidoComida);
        Pedido pedidoComida2 = new PedidoComida("100abc", "comida",
                new Direccion("Las parcelas", 8284, "Peñalolen", "metropolitana"),
                2);
        despacho.agregarPedidoHistorial(pedidoComida2);


        // --- Creo una lista de repartidores ---
        List<Repartidor> repartidores = new ArrayList<Repartidor>();

        // --- Creando repartidores para la lista y agregarlos a la lista ---
        Repartidor moto = new Repartidor("Juanito Reyes", "Moto", true, true, 5.6);
        repartidores.add(moto);
        Repartidor moto2 = new Repartidor("Alejandro Arenas", "Moto", true, true, 6.7);
        repartidores.add(moto2);

        // **se asigna libre (3º atributo) como false para comprobar estatus del repartidor antes de darle pedido
        Repartidor auto = new Repartidor("Miguel Angel", "Auto",false, false, 2.4);
        repartidores.add(auto);
        Repartidor auto2 = new Repartidor("Donattello Boniacci", "Auto",true, true, 3);
        repartidores.add(auto2);

        Repartidor camioneta = new Repartidor("Ana de Armas", "Camioneta", true, false, 10);
        repartidores.add(camioneta);
        Repartidor camioneta2 = new Repartidor("Sara Melas", "Camioneta", true, false, 10);
        repartidores.add(camioneta2);


        // Cancelando un pedido de forma manual
        despacho.cancelar(pedidoExpress2);


        // Asigno un repartidor de forma manuel, fuera de la lista de objetos
        System.out.println(pedidoComida2.asignarRepartidor("Javier Calabrano"));


        //Creo lista para uso de objetos almacenados
        List<Pedido> historialPedidos = despacho.verHistorial();

        // Ciclo para asignar repartidores automaticamente
        for (Pedido pedido : historialPedidos) {
            pedido.asignarRepartidor(repartidores, pedido);
        }

        // Ciclo que imprime la información completa de cada pedido como le leería el cliente
        for (Pedido pedido : historialPedidos) {
            System.out.println(pedido.mostrarResumen());
        }

        // Ciclo que imprime el resumen de la informacion para el registro del historial para repportes
        for (Pedido pedido : historialPedidos) {
            System.out.println(pedido.mostrarHistorial());
        }



    }
}
