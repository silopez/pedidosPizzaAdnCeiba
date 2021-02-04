package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.CrearPedidoServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.DetallePedidoComandoTestDataBuilder;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class PedidoCrearDetalleTest {

	@Test
    public void validarExistenciaPizzaPedido() {
		DetallePedidoComando detallePedidoComando = new DetallePedidoComandoTestDataBuilder().buildSinPizzas();
        Pedido pedido = new PedidoTestDataBuilder().build();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        Mockito.when(pedidoRepositorio.crear(pedido)).thenReturn(pedido);
        CrearPedidoServicio crearPedidoServicio = new CrearPedidoServicio(pedidoRepositorio);
        try {
        	crearPedidoServicio.crear(pedido, detallePedidoComando);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.NO_EXISTE_PIZZA_PEDIDO.getMensaje());
		}        
    }
	
	@Test
    public void validarDetalleMasCincoPizzaPedido() {
		DetallePedidoComando detallePedidoComando = new DetallePedidoComandoTestDataBuilder().buildDetalleMasCincoPizzas();
        Pedido pedido = new PedidoTestDataBuilder().build();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        Mockito.when(pedidoRepositorio.crear(pedido)).thenReturn(pedido);
        CrearPedidoServicio crearPedidoServicio = new CrearPedidoServicio(pedidoRepositorio);
        try {
        	crearPedidoServicio.crear(pedido, detallePedidoComando);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.CANTIDAD_INVALIDAD_PIZZA_PEDIDO.getMensaje());
		}        
    }
	
	@Test
    public void validarDetalleMasTresAdicionesPedido() {
		DetallePedidoComando detallePedidoComando = new DetallePedidoComandoTestDataBuilder().buildDetalleMasTresDetalles();
        Pedido pedido = new PedidoTestDataBuilder().build();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        Mockito.when(pedidoRepositorio.crear(pedido)).thenReturn(pedido);
        CrearPedidoServicio crearPedidoServicio = new CrearPedidoServicio(pedidoRepositorio);
        try {
        	crearPedidoServicio.crear(pedido, detallePedidoComando);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.CANTIDAD_INVALIDADO_ADICION_PIZZA.getMensaje()
					+ detallePedidoComando.getDetallePizzasComando().get(0).getPizzaComando().getNombre());
		}        
    }
}
