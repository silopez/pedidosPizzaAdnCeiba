package com.pedidospizza.adnceiba.pedido.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.PedidoComando;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;

@Component
public class PedidoFabrica {
	
	public Pedido crearPedido(PedidoComando pedidoComando) {
        return new Pedido(pedidoComando.getId(), pedidoComando.getNombre(), pedidoComando.getDireccion(), pedidoComando.getTotal(), pedidoComando.getEstadoPedido(), pedidoComando.getFechaPedido());
    }
}
