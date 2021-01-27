package com.pedidospizza.adnceiba.pizza.dominio.puerto;

import java.util.List;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;

public interface PizzaDao {
	
	/**
     * Permite consultar todos las pizzas
     * @return Lista de Lista de pizzas
     */
    List<PizzaDto> getPizzas();
}
