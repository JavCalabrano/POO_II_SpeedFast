package org.example.model;


import java.time.LocalDate;
import java.time.LocalTime;

public class Entrega {

    private int id, idPedido, idRepartidor;
    private LocalDate fecha;
    private LocalTime hora;


    public Entrega( int id, int idPedido, int idRepartidor, LocalDate fecha, LocalTime hora ) {
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
        this.fecha = fecha;
        this.hora = hora;
    }


}
