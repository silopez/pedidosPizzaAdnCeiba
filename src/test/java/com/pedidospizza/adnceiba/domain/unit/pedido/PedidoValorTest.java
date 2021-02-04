package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoValorTest {

	@Test
    public void validarValorMininoTest() {
		try {
			new PedidoTestDataBuilder().buildValorMinimo();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.VALOR_MINIMO_PEDIDO.getMensaje());
		}
    }
	
}
