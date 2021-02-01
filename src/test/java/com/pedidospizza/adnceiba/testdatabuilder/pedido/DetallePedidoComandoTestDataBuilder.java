package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.List;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePizzaComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.PedidoComando;

public class DetallePedidoComandoTestDataBuilder {
	PedidoComando pedidoComando;
	List<DetallePizzaComando> listaDetallePizzaComando;
	
	
	public DetallePedidoComandoTestDataBuilder() {
		this.pedidoComando = new PedidoComandoTestDataBuilder().build();
		this.listaDetallePizzaComando = new DetallePizzaComandoTestDataBuilder().getAllDetallePizzaComando();
    }
	
	public DetallePedidoComando build() {
		return new DetallePedidoComando(pedidoComando, listaDetallePizzaComando);
	}
}
