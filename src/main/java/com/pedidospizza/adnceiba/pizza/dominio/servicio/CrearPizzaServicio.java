package com.pedidospizza.adnceiba.pizza.dominio.servicio;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;

public class CrearPizzaServicio {
	
	private final PizzaRepositorio pizzaRepositorio;

    public CrearPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        this.pizzaRepositorio = pizzaRepositorio;
    }

    public Pizza crear(Pizza pizza) {
        return this.pizzaRepositorio.crear(pizza);
    }
}
