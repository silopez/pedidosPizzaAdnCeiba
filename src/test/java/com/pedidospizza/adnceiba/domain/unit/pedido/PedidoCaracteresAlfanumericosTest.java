package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoCaracteresAlfanumericosTest {

	@Test
    public void validarCamposNombreNoAlfanumerico() {
		try {
			new PedidoTestDataBuilder().buildNoAlfanumericoNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.PEDIDO_NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		}
    }
}
