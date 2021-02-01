package com.pedidospizza.adnceiba.pedido.dominio.servicio;

import java.util.List;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;

public class ConsultarPedidoServicio {
	
	private final PedidoDao pedidoDao;

    public ConsultarPedidoServicio(PedidoDao pedidoDao) {
        this.pedidoDao = pedidoDao;
    }

    public List<PedidoDto> getAllPedidos() {
        return pedidoDao.getPedidos();
    }
    
    public PedidoDto getPedidoPorId(Long id) {
    	return pedidoDao.getPedidoPorId(id);
    }
}
