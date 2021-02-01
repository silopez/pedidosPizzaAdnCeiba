package com.pedidospizza.adnceiba.pedido.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pedido.dominio.servicio.ModificarEstadoPedidoServicio;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;


@Component
public class ModificarEstadoPedidoManejador {
	
	private final ModificarEstadoPedidoServicio modificarEstadoPedidoServicio;

    public ModificarEstadoPedidoManejador(ModificarEstadoPedidoServicio modificarEstadoPedidoServicio) {
        this.modificarEstadoPedidoServicio = modificarEstadoPedidoServicio;
    }

    @Transactional
    public void ejecutar(Long id, EstadoPedidoEnum estadoPedido) {
        modificarEstadoPedidoServicio.ejecutar(id, estadoPedido);
    }
}
