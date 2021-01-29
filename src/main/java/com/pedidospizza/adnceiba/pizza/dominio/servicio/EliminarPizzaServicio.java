package com.pedidospizza.adnceiba.pizza.dominio.servicio;

import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

public class EliminarPizzaServicio {

	private final PizzaRepositorio pizzaRepositorio;

    public EliminarPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        this.pizzaRepositorio = pizzaRepositorio;
    }

    public void ejecutar(Long idPizza) {
    	
    	PizzaEntidad pizzaEntidad = pizzaRepositorio.bucarEntidad(idPizza);
    	
    	if(pizzaEntidad != null) {
    		pizzaRepositorio.eliminar(pizzaEntidad);
    	}        
    }
}
