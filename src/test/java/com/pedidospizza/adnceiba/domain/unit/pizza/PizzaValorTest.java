package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PizzaValorTest {
	
	@Test
    public void validarValorMininoTest() {
		try {
			new PizzaTestDataBuilder().buildValorMinimo();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_MINIMO_PIZZA.getMensaje());
		}
    }
	
	@Test
    public void validarValorMaximoTest() {
		try {
			new PizzaTestDataBuilder().buildValorMaximo();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_MAXIMO_PIZZA.getMensaje());
		}
    }
}
