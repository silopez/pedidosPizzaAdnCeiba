package com.pedidospizza.adnceiba.pedido.dominio.puerto;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

public interface PedidoRepositorio {

	/**
     * Nos permite crear un pedidos
     * @param pedido
     * @return id pedido
     */
    Pedido crear(Pedido pedido);

    /**
     * Nos permite actualizar un pedido creada anteriormente
     * @param id
     */
    Pedido actualizar(Pedido pedido);

	void cambiarEstadoPedido(Long id, EstadoPedidoEnum estadoPedido);

}
