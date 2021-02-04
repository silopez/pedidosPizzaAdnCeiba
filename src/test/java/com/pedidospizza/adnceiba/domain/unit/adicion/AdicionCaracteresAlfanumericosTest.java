package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionCaracteresAlfanumericosTest {

	@Test
    public void validarCamposNombreNoAlfanumerico() {
		try {
			new AdicionTestDataBuilder().buildNoAlfanumericoNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDescripcionNoAlfanumerico() {
		try {
			new AdicionTestDataBuilder().buildNoAlfanumericoDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_DESCRIPCION_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		}
    }
	
}
