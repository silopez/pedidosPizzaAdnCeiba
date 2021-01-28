package com.pedidospizza.adnceiba.pizza.dominio.servicio;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;

public class ActualizarPizzaServicio {

	private final PizzaRepositorio pizzaRepositorio;

    public ActualizarPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        this.pizzaRepositorio = pizzaRepositorio;
    }

    public Pizza ejecutar(Pizza pizza) {
        return this.pizzaRepositorio.actualizar(pizza);
    }
	
}
