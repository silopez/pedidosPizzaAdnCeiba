package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.CrearPedidoServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.DetallePedidoComandoTestDataBuilder;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;

public class PedidoTest {
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
	
	@Test
    public void validarlistarTodasPedido() {
        List<PedidoDto> pedidos = new PedidoTestDataBuilder().buildAllPedido();
        PedidoDao pedidoDao = Mockito.mock(PedidoDao.class);
        Mockito.when(pedidoDao.getPedidos()).thenReturn(pedidos);
        ConsultarPedidoServicio consultarPedidoServicio = new ConsultarPedidoServicio(pedidoDao);
        List<PedidoDto> listaPedidosBuscados = consultarPedidoServicio.getAllPedidos();
        assertEquals(listaPedidosBuscados, pedidos);
    }
}
