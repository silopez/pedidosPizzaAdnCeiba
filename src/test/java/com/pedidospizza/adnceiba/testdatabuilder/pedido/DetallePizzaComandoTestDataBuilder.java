package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionComandoTestDataBuilder;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaComandoTestDataBuilder;

public class DetallePizzaComandoTestDataBuilder {

	PizzaComando pizzaComando;
	List<AdicionComando> listaAdicionesComando;
	
	
	public DetallePizzaComandoTestDataBuilder() {
		this.pizzaComando = new PizzaComandoTestDataBuilder().build();
		this.listaAdicionesComando = new AdicionComandoTestDataBuilder().buildAllAdicionComando();
    }
	
	public List<DetallePizzaComando> getAllDetallePizzaComando() {
		
		List<DetallePizzaComando> listaDetallePizzaComando = new ArrayList<DetallePizzaComando>();
		
		PizzaComando pizzaComando1 = new PizzaComandoTestDataBuilder().build();
		List<AdicionComando> listaAdicionesComando1 = new AdicionComandoTestDataBuilder().buildAllAdicionComando();
		
		DetallePizzaComando detallePizzaComando1 = new DetallePizzaComando(pizzaComando1, listaAdicionesComando1);
		listaDetallePizzaComando.add(detallePizzaComando1);
		
		PizzaComando pizzaComando2 = new PizzaComandoTestDataBuilder().build2();
		List<AdicionComando> listaAdicionesComando2 = new AdicionComandoTestDataBuilder().buildAllAdicionComando();
		
		DetallePizzaComando detallePizzaComando2 = new DetallePizzaComando(pizzaComando2, listaAdicionesComando2);
		listaDetallePizzaComando.add(detallePizzaComando2);
	
		
		return listaDetallePizzaComando;
    }
}
