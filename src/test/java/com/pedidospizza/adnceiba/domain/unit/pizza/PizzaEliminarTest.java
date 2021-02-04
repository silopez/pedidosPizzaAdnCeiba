package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.EliminarPizzaServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PizzaEliminarTest {
	@Test
    public void validarEliminarPizzaNoEncontrada() {
        Pizza pizza = new PizzaTestDataBuilder().build();
        PizzaRepositorio pizzaRepositorio = Mockito.mock(PizzaRepositorio.class);
        Mockito.when(pizzaRepositorio.bucarEntidad(pizza.getId())).thenReturn(null);
        EliminarPizzaServicio eliminarPizzaServicio = new EliminarPizzaServicio(pizzaRepositorio);
        
        try {
        	eliminarPizzaServicio.ejecutar(pizza.getId());
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.PIZZA_INEXISTENTE_ELIMINAR.getMensaje());
		}
    }
}
