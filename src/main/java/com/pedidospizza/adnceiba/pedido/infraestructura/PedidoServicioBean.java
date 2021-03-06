package com.pedidospizza.adnceiba.pedido.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ConsultarPedidoServicio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.CrearPedidoServicio;
import com.pedidospizza.adnceiba.pedido.dominio.servicio.ModificarEstadoPedidoServicio;

@Configuration
public class PedidoServicioBean {
	
	@Bean
    public CrearPedidoServicio crearPedidoServicio(PedidoRepositorio pedidoRepositorio) {
        return new CrearPedidoServicio(pedidoRepositorio);
    }

    @Bean
    public ConsultarPedidoServicio consultarPedidoServicio(PedidoDao pedidoDao) {
        return new ConsultarPedidoServicio(pedidoDao);
    }
    
    @Bean ModificarEstadoPedidoServicio modificarEstadoPedidoServicio(PedidoRepositorio pedidoRepositorio, ConsultarPedidoServicio consultarPedidoServicio) {
    	return new ModificarEstadoPedidoServicio(pedidoRepositorio, consultarPedidoServicio);
    }
}
