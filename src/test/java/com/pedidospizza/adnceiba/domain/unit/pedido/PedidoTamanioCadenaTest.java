package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoTamanioCadenaTest {

	@Test
    public void validarCamposNombreTamanioCadenaTest() {
		try {
			new PedidoTestDataBuilder().buildTamanioNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.PEDIDO_NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDireccionTamanioCadenaTest() {
		try {
			new PedidoTestDataBuilder().buildTamanioDireccion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.PEDIDO_DIRECCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		}
    }
}
