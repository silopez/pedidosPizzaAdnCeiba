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

public class PedidoCrearTest {
	@Test
    public void validarCreacionPedido() {
		DetallePedidoComando detallePedidoComando = new DetallePedidoComandoTestDataBuilder().build();
        Pedido pedido = new PedidoTestDataBuilder().build();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        Mockito.when(pedidoRepositorio.crear(pedido)).thenReturn(pedido);
        CrearPedidoServicio crearPedidoServicio = new CrearPedidoServicio(pedidoRepositorio);
        Pedido nuevaPedidoCreado = crearPedidoServicio.crear(pedido, detallePedidoComando);
        assertEquals(nuevaPedidoCreado, pedido);
    }
}
