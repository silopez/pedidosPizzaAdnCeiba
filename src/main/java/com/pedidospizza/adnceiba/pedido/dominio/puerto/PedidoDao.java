package com.pedidospizza.adnceiba.pedido.dominio.puerto;

import java.util.List;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;

public interface PedidoDao {
	
	/**
     * Permite consultar todos los pedidos de pizzas
     * @return Lista de pedidos
     */
    List<PedidoDto> getPedidos();

	PedidoDto getPedidoPorId(Long id);

}
