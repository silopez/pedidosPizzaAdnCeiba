package com.pedidospizza.adnceiba.pizza.dominio.servicio;

import java.util.List;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaDao;

public class ConsultarPizzaServicio {
	
	private final PizzaDao pizzaDao;

    public ConsultarPizzaServicio(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public List<PizzaDto> getAllPizzas() {
        return pizzaDao.getPizzas();
    }
}
