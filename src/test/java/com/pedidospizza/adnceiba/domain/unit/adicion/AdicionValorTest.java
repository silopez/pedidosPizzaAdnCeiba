package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionValorTest {
	@Test
    public void validarValorMininoTest() {
		try {
			new AdicionTestDataBuilder().buildValorMinimo();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_MINIMO_ADICION.getMensaje());
		}
    }
	
	@Test
    public void validarValorMaximoTest() {
		try {
			new AdicionTestDataBuilder().buildValorMaximo();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_MAXIMO_ADICION.getMensaje());
		}
    }
}
