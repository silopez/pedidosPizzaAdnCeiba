package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionCamposNulosTest {
	
	@Test
    public void validarCamposNombreNullo() {
		try {
			new AdicionTestDataBuilder().buildNulloNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NOMBRE_ADICION_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDescripcionNullo() {
		try {
			new AdicionTestDataBuilder().buildNulloDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.DESCRIPCION_ADICION_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposValorNullo() {
		try {
			new AdicionTestDataBuilder().buildNulloValor();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_ADICION_OBLIGATORIO.getMensaje());
		}
    }
}
