package com.pedidospizza.adnceiba.pedido.dominio.servicio;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;

public class CrearPedidoServicio {
	
	private final PedidoRepositorio pedidoRepositorio;

    public CrearPedidoServicio(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido crear(Pedido pedido) {
        return this.pedidoRepositorio.crear(pedido);
    }
}
