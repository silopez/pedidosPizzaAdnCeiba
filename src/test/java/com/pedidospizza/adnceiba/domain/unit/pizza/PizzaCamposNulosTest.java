package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PizzaCamposNulosTest {

	@Test
    public void validarCamposNombreNullo() {
		try {
			new PizzaTestDataBuilder().buildNulloNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NOMBRE_PIZZA_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposTipoNullo() {
		try {
			new PizzaTestDataBuilder().buildNulloDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.TIPO_PIZZA_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposValorNullo() {
		try {
			new PizzaTestDataBuilder().buildNulloValor();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_PIZZA_OBLIGATORIO.getMensaje());
		}
    }
}
