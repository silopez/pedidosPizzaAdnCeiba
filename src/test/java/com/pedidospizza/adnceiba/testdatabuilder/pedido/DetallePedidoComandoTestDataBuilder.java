package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.ArrayList;
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
	
	public DetallePedidoComando buildSinPizzas() {
		
		List<DetallePizzaComando> listaSinDetallePizzaComando = new ArrayList<DetallePizzaComando>();
		
		return new DetallePedidoComando(pedidoComando, listaSinDetallePizzaComando);
	}
	
	public DetallePedidoComando buildDetalleMasCincoPizzas() {
		
		List<DetallePizzaComando> listaCincoDetallePizzaComando = new DetallePizzaComandoTestDataBuilder().buildMasDeCincoDetallePizzaComando();
		
		return new DetallePedidoComando(pedidoComando, listaCincoDetallePizzaComando);
	}
	
public DetallePedidoComando buildDetalleMasTresDetalles() {
		
		List<DetallePizzaComando> listaCincoDetallePizzaComando = new DetallePizzaComandoTestDataBuilder().buildMasDeTresAdicionesDetallePizzaComando();
		
		return new DetallePedidoComando(pedidoComando, listaCincoDetallePizzaComando);
	}
}
