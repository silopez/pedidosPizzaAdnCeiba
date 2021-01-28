package com.pedidospizza.adnceiba.pedido.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.PedidoComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.fabrica.PedidoFabrica;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.CrearPedidoServicio;

@Component
public class CrearPedidoManejador {
	
	private final CrearPedidoServicio crearPedidoServicio;
    private final PedidoFabrica pedidoFabrica;

    public CrearPedidoManejador(CrearPedidoServicio crearPedidoServicio, PedidoFabrica pedidoFabrica) {
        this.crearPedidoServicio = crearPedidoServicio;
        this.pedidoFabrica = pedidoFabrica;
    }

    @Transactional
    public Pedido ejecutar(PedidoComando pedidoComando) {
    	Pedido pedido = pedidoFabrica.crearPedido(pedidoComando);
        return crearPedidoServicio.crear(pedido);
    }
}
