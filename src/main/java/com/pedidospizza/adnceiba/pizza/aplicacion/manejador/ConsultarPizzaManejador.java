package com.pedidospizza.adnceiba.pizza.aplicacion.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ConsultarPizzaServicio;

@Component
public class ConsultarPizzaManejador {
	private final ConsultarPizzaServicio consultarPizzaServicio;

    public ConsultarPizzaManejador(ConsultarPizzaServicio consultarPizzaServicio) {
        this.consultarPizzaServicio = consultarPizzaServicio;
    }

    public List<PizzaDto> obtenerTodasPizzas() {
        return consultarPizzaServicio.getAllPizzas();
    }
}
