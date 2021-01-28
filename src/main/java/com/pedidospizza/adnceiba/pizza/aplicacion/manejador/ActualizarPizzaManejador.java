package com.pedidospizza.adnceiba.pizza.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.fabrica.PizzaFabrica;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ActualizarPizzaServicio;

@Component
public class ActualizarPizzaManejador {
	
	private final ActualizarPizzaServicio actualizarPizzaServicio;
	private final PizzaFabrica pizzaFabrica;

    public ActualizarPizzaManejador(ActualizarPizzaServicio actualizarPizzaServicio, PizzaFabrica pizzaFabrica) {
        this.actualizarPizzaServicio = actualizarPizzaServicio;
        this.pizzaFabrica = pizzaFabrica;
    }

    @Transactional
    public Pizza ejecutar(PizzaComando pizzaComando) {
    	Pizza pizza = pizzaFabrica.crearPizza(pizzaComando);
        return actualizarPizzaServicio.ejecutar(pizza);
    }
}
