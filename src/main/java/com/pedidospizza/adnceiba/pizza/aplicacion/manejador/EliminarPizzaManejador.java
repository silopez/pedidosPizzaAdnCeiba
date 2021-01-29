package com.pedidospizza.adnceiba.pizza.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pizza.dominio.servicio.EliminarPizzaServicio;

@Component
public class EliminarPizzaManejador {
	
	private final EliminarPizzaServicio eliminarPizzaServicio;

    public EliminarPizzaManejador(EliminarPizzaServicio eliminarPizzaServicio) {
        this.eliminarPizzaServicio = eliminarPizzaServicio;
    }

    @Transactional
    public void ejecutar(Long idPizza) {
        eliminarPizzaServicio.ejecutar(idPizza);
    }

}
