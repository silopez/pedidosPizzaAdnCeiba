package com.pedidospizza.adnceiba.domain.unit.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PizzaCaracteresAlfanumericos {

	@Test
    public void validarCamposNombreNoAlfanumerico() {
		try {
			new PizzaTestDataBuilder().buildNoAlfanumericoNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		}
    }
	
	@Test
    public void validarCamposTipoNoAlfanumerico() {
		try {
			new PizzaTestDataBuilder().buildNoAlfanumericoDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.TIPO_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		}
    }
}
