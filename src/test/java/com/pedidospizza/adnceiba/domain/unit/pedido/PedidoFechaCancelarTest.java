package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pedido.dominio.enums.EstadoPedidoEnum;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ModificarEstadoPedidoServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoDtoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoFechaCancelarTest {
	

	@Test
    public void validarFechaCancelarYaEntregadoPedidoTest() {
		
        PedidoDto pedidoDto = new PedidoDtoTestDataBuilder().buildEstadoEntregado();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        ConsultarPedidoServicio consultarPedidoServicio = Mockito.mock(ConsultarPedidoServicio.class);
        Mockito.when(consultarPedidoServicio.getPedidoPorId(pedidoDto.getId())).thenReturn(pedidoDto);
        ModificarEstadoPedidoServicio modificarEstadoPedidoServicio = new ModificarEstadoPedidoServicio(pedidoRepositorio,consultarPedidoServicio);
        try {
        	modificarEstadoPedidoServicio.ejecutar(pedidoDto.getId(), EstadoPedidoEnum.CANCELADO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ESTADO_PEDIDO_CANCELADO_ENTREGADO_INVALIDO.getMensaje());
		}
    }
	
	@Test
    public void validarFechaCancelarTiempoPedidoTest() {
		
        PedidoDto pedidoDto = new PedidoDtoTestDataBuilder().buildFechaCaducada();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        ConsultarPedidoServicio consultarPedidoServicio = Mockito.mock(ConsultarPedidoServicio.class);
        Mockito.when(consultarPedidoServicio.getPedidoPorId(pedidoDto.getId())).thenReturn(pedidoDto);
        ModificarEstadoPedidoServicio modificarEstadoPedidoServicio = new ModificarEstadoPedidoServicio(pedidoRepositorio,consultarPedidoServicio);
        try {
        	modificarEstadoPedidoServicio.ejecutar(pedidoDto.getId(), EstadoPedidoEnum.CANCELADO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ESTADO_PEDIDO_CANCELADO_TIEMPO_INVALIDO.getMensaje());
		}
    }
	
	@Test
    public void validarEstadoAnterioPedidoTest() {
		
        PedidoDto pedidoDto = new PedidoDtoTestDataBuilder().buildEstadoEntregado();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        ConsultarPedidoServicio consultarPedidoServicio = Mockito.mock(ConsultarPedidoServicio.class);
        Mockito.when(consultarPedidoServicio.getPedidoPorId(pedidoDto.getId())).thenReturn(pedidoDto);
        ModificarEstadoPedidoServicio modificarEstadoPedidoServicio = new ModificarEstadoPedidoServicio(pedidoRepositorio,consultarPedidoServicio);
        try {
        	modificarEstadoPedidoServicio.ejecutar(pedidoDto.getId(), EstadoPedidoEnum.EN_CAMINO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ESTADO_PEDIDO_CAMBIAR_INVALIDO.getMensaje());
		}
    }
}
