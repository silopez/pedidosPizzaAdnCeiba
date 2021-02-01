package com.pedidospizza.adnceiba.pedido.aplicacion.comando;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePedidoComando {

	PedidoComando pedidoComando;
	List<DetallePizzaComando> detallePizzasComando;
	
	public DetallePedidoComando() {}

	public DetallePedidoComando(PedidoComando pedidoComando,List<DetallePizzaComando> detallePizzasComando) {
		this.pedidoComando = pedidoComando;
		this.detallePizzasComando = detallePizzasComando;
	}	
	
}
