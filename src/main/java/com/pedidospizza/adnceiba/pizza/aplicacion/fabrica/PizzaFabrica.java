package com.pedidospizza.adnceiba.pizza.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;

@Component
public class PizzaFabrica {
	public Pizza crearPizza(PizzaComando pizzaComando) {
        return new Pizza(pizzaComando.getId(), pizzaComando.getNombre(), pizzaComando.getTipo(), pizzaComando.getValor());
    }
	
	public Pizza actualizarPizza(PizzaComando pizzaComando) {
        return new Pizza(pizzaComando.getId(), pizzaComando.getNombre(), pizzaComando.getTipo(), pizzaComando.getValor());
    }
}
