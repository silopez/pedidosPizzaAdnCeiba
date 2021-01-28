package com.pedidospizza.adnceiba.pedido.aplicacion.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;

@Component
public class ConsultarPedidoManejador {
	
	private final ConsultarPedidoServicio consultarPedidoServicio;

    public ConsultarPedidoManejador(ConsultarPedidoServicio consultarPedidoServicio) {
        this.consultarPedidoServicio = consultarPedidoServicio;
    }

    public List<PedidoDto> obtenerTodosPedidos() {
        return consultarPedidoServicio.getAllPedidos();
    }
}
