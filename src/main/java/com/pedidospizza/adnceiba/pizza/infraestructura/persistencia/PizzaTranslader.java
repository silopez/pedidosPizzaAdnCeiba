package com.pedidospizza.adnceiba.pizza.infraestructura.persistencia;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

public class PizzaTranslader {
	
	private PizzaTranslader() {}

    public static PizzaEntidad parsePizzaToEntidad(Pizza pizza) {
        return new PizzaEntidad(pizza.getNombre(), pizza.getTipo(), pizza.getValor());
    }

    public static PizzaDto parsePizzaToDto(PizzaEntidad pizzaEntidad) {
        return new PizzaDto(pizzaEntidad.getId(), pizzaEntidad.getNombre(), pizzaEntidad.getTipo(), pizzaEntidad.getValor());
    }
    
}
