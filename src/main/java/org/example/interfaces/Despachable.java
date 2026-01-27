package org.example.interfaces;

import org.example.model.Pedido;
import org.example.model.Repartidor;

public interface Despachable {

    public void despachar(Repartidor repartidor, Pedido pedido);


}
