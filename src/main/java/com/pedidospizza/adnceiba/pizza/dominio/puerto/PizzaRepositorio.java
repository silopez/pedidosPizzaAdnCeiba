package com.pedidospizza.adnceiba.pizza.dominio.puerto;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;

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
     * Nos permite eliminar una pizza creada anteriormente
     * @param id
     */
    void eliminar(Long id);
}
