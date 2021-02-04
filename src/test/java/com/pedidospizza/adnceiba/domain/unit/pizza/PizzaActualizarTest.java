package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ActualizarPizzaServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;

public class PizzaActualizarTest {

	@Test
    public void validarActualizarPizza() {
		Pizza pizza = new PizzaTestDataBuilder().build();
        PizzaRepositorio pizzaRepositorio = Mockito.mock(PizzaRepositorio.class);
        Mockito.when(pizzaRepositorio.actualizar(pizza)).thenReturn(pizza);
        ActualizarPizzaServicio actulizarPizzaServicio = new ActualizarPizzaServicio(pizzaRepositorio);
        Pizza pizzaActualizada = actulizarPizzaServicio.ejecutar(pizza);
        assertEquals(pizzaActualizada, pizza);
    }
}
