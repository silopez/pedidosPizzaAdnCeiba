package com.pedidospizza.adnceiba.domain.unit.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.PedidoTestDataBuilder;

public class PedidoListarTest {
	
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
