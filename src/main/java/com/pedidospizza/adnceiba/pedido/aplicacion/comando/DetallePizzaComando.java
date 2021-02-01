package com.pedidospizza.adnceiba.pedido.aplicacion.comando;

import java.util.List;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePizzaComando {
	
	PizzaComando pizzaComando;
	List<AdicionComando> listaAdicionesComando;
	
	public DetallePizzaComando() {}

	public DetallePizzaComando(PizzaComando pizzaComando,List<AdicionComando> listaAdicionesComando) {
		this.pizzaComando = pizzaComando;
		this.listaAdicionesComando = listaAdicionesComando;
	}
	
}
