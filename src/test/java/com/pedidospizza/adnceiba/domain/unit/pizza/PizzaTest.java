package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaDao;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ActualizarPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.ConsultarPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.CrearPizzaServicio;
import com.pedidospizza.adnceiba.pizza.dominio.servicio.EliminarPizzaServicio;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaDtoTestDataBuilder;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaComandoTestDataBuilder;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;

public class PizzaTest {
	@Test
    public void validarCreacionPizza() {
        Pizza pizza = new PizzaTestDataBuilder().build();
        PizzaRepositorio pizzaRepositorio = Mockito.mock(PizzaRepositorio.class);
        Mockito.when(pizzaRepositorio.crear(pizza)).thenReturn(pizza);
        CrearPizzaServicio crearPizzaServicio = new CrearPizzaServicio(pizzaRepositorio);
        Pizza nuevaPizzaCreada = crearPizzaServicio.crear(pizza);
        assertEquals(nuevaPizzaCreada, pizza);
    }
	
	@Test
    public void validarlistarTodasPizzas() {
        List<PizzaDto> pizzas = new PizzaDtoTestDataBuilder().buildAllPizzaDto();
        PizzaDao pizzaDao = Mockito.mock(PizzaDao.class);
        Mockito.when(pizzaDao.getPizzas()).thenReturn(pizzas);
        ConsultarPizzaServicio consultarPizzaServicio = new ConsultarPizzaServicio(pizzaDao);
        List<PizzaDto> listaPizzasBuscadas = consultarPizzaServicio.getAllPizzas();
        assertEquals(listaPizzasBuscadas, pizzas);
    }
	
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
