package com.pedidospizza.adnceiba.pizza.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaDao;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ActualizarPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ConsultarPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.CrearPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.EliminarPizzaServicio;

@Configuration
public class PizzaServicioBean {
	@Bean
    public CrearPizzaServicio crearPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        return new CrearPizzaServicio(pizzaRepositorio);
    }

    @Bean
    public ConsultarPizzaServicio consultarPizzaServicio(PizzaDao pizzaDao) {
        return new ConsultarPizzaServicio(pizzaDao);
    }
    
    @Bean
    public ActualizarPizzaServicio actualizarPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        return new ActualizarPizzaServicio(pizzaRepositorio);
    }
    
    @Bean
    public EliminarPizzaServicio eliminarPizzaServicio(PizzaRepositorio pizzaRepositorio) {
        return new EliminarPizzaServicio(pizzaRepositorio);
    }
}
