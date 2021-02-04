package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.CrearPizzaServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;

public class PizzaCrearTest {
	@Test
    public void validarCreacionPizza() {
        Pizza pizza = new PizzaTestDataBuilder().build();
        PizzaRepositorio pizzaRepositorio = Mockito.mock(PizzaRepositorio.class);
        Mockito.when(pizzaRepositorio.crear(pizza)).thenReturn(pizza);
        CrearPizzaServicio crearPizzaServicio = new CrearPizzaServicio(pizzaRepositorio);
        Pizza nuevaPizzaCreada = crearPizzaServicio.crear(pizza);
        assertEquals(nuevaPizzaCreada, pizza);
    }

}
