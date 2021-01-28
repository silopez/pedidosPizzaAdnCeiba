package com.pedidospizza.adnceiba.domain.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.CrearPedidoServicio;
import com.pedidospizza.adnceiba.testdatabuilder.PedidoTestDataBuilder;

public class PedidoTest {
	@Test
    public void validarCreacionPedido() {
        Pedido pedido = new PedidoTestDataBuilder().build();
        PedidoRepositorio pedidoRepositorio = Mockito.mock(PedidoRepositorio.class);
        Mockito.when(pedidoRepositorio.crear(pedido)).thenReturn(pedido);
        CrearPedidoServicio crearPedidoServicio = new CrearPedidoServicio(pedidoRepositorio);
        Pedido nuevaPedidoCreado = crearPedidoServicio.crear(pedido);
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
