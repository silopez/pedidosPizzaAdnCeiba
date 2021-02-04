package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PizzaTamanioCadenaTest {

	@Test
    public void validarCamposNombreTamanioCadenaTest() {
		try {
			new PizzaTestDataBuilder().buildTamanioNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDescripcionTamanioCadenaTest() {
		try {
			new PizzaTestDataBuilder().buildTamanioDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.TIPO_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		}
    }
}
