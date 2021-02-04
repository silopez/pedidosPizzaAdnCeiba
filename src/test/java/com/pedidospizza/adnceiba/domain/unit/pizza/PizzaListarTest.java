package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaDao;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ConsultarPizzaServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaDtoTestDataBuilder;

public class PizzaListarTest {

	@Test
    public void validarlistarTodasPizzas() {
        List<PizzaDto> pizzas = new PizzaDtoTestDataBuilder().buildAllPizzaDto();
        PizzaDao pizzaDao = Mockito.mock(PizzaDao.class);
        Mockito.when(pizzaDao.getPizzas()).thenReturn(pizzas);
        ConsultarPizzaServicio consultarPizzaServicio = new ConsultarPizzaServicio(pizzaDao);
        List<PizzaDto> listaPizzasBuscadas = consultarPizzaServicio.getAllPizzas();
        assertEquals(listaPizzasBuscadas, pizzas);
    }
}
