package com.pedidospizza.adnceiba.pizza.infraestructura.persistencia;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

public class PizzaTranslader {
	
	public PizzaTranslader() {
    }

    public static PizzaEntidad parsePizzaToEntidad(Pizza pizza) {
        PizzaEntidad pizzaEntidad = new PizzaEntidad(pizza.getNombre(), pizza.getTipo(), pizza.getValor());
        return pizzaEntidad;
    }

    public static PizzaDto parsePizzaToDto(PizzaEntidad pizzaEntidad) {
        return new PizzaDto(pizzaEntidad.getId(), pizzaEntidad.getNombre(), pizzaEntidad.getTipo(), pizzaEntidad.getValor());
    }
    
}
