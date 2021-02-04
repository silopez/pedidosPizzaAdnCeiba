package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionTamanioCadenaTest {

	@Test
    public void validarCamposNombreTamanioCadenaTest() {
		try {
			new AdicionTestDataBuilder().buildTamanioNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDescripcionTamanioCadenaTest() {
		try {
			new AdicionTestDataBuilder().buildTamanioDescripcion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_DESCRIPCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		}
    }
}
