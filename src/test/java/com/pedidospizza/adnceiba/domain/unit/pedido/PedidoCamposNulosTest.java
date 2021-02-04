package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoCamposNulosTest {
	@Test
    public void validarCamposNombreNullo() {
		try {
			new PedidoTestDataBuilder().buildNulloNombre();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NOMBRE_PEDIDO_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposDireccionNullo() {
		try {
			new PedidoTestDataBuilder().buildNulloDireccion();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.DIRECCION_PEDIDO_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposTotalNullo() {
		try {
			new PedidoTestDataBuilder().buildNulloTotal();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.TOTAL_PEDIDO_OBLIGATORIO.getMensaje());
		}
    }
	
	@Test
    public void validarCamposEstadoPedidoNullo() {
		try {
			new PedidoTestDataBuilder().buildNulloEstadoPedido();
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ESTADO_PEDIDO_PEDIDO_OBLIGATORIO.getMensaje());
		}
    }
}
