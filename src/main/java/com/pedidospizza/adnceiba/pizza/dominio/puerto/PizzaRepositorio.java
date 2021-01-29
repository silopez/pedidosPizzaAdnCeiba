package com.pedidospizza.adnceiba.pizza.dominio.puerto;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

public interface PizzaRepositorio {
	
	/**
     * Nos permite crear una pizza
     * @param pizza
     * @return id pizza
     */
    Pizza crear(Pizza pizza);

    /**
     * Nos permite actualizar una pizza creada anteriormente
     * @param id
     */
    Pizza actualizar(Pizza adicion);

    /**
     * Nos permite buscar una pizza creada anteriormente
     * @param id
     */
	PizzaDto bucarPorId(Long id);

	/**
     * Nos permite eliminar una pizza creada anteriormente
     * @param id
     */
	void eliminar(PizzaEntidad pizzaEntidad);

	/**
     * Nos permite buscar por Id la entidad
     * @param id
     */
	PizzaEntidad bucarEntidad(Long id);
}
