package com.pedidospizza.adnceiba.pizza.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.fabrica.PizzaFabrica;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.CrearPizzaServicio;

@Component
public class CrearPizzaManejador {
	private final CrearPizzaServicio crearPizzaServicio;
    private final PizzaFabrica pizzaFabrica;

    public CrearPizzaManejador(CrearPizzaServicio crearPizzaServicio, PizzaFabrica pizzaFabrica) {
        this.crearPizzaServicio = crearPizzaServicio;
        this.pizzaFabrica = pizzaFabrica;
    }

    @Transactional
    public Pizza ejecutar(PizzaComando pizzaComando) {
    	Pizza pizza = pizzaFabrica.crearPizza(pizzaComando);
        return crearPizzaServicio.crear(pizza);
    }
}
