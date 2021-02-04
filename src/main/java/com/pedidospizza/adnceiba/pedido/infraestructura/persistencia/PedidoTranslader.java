package com.pedidospizza.adnceiba.pedido.infraestructura.persistencia;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.entidad.PedidoEntidad;

public class PedidoTranslader {
	
	private PedidoTranslader() {}
	
    public static PedidoEntidad parsePedidoToEntidad(Pedido pedido) {
        PedidoEntidad pedidoEntidad = new PedidoEntidad();
        pedidoEntidad.setNombre(pedido.getNombre());
        pedidoEntidad.setDireccion(pedido.getDireccion());
        pedidoEntidad.setTotal(pedido.getTotal());
        pedidoEntidad.setEstadoPedido(pedido.getEstadoPedido());
        pedidoEntidad.setFechaPedido(pedido.getFechaPedido());
        return pedidoEntidad;
    }

    public static PedidoDto parsePedidoToDto(PedidoEntidad pedidoEntidad) {
        return new PedidoDto(pedidoEntidad.getId(), pedidoEntidad.getNombre(), pedidoEntidad.getDireccion(), pedidoEntidad.getTotal(), pedidoEntidad.getEstadoPedido(), pedidoEntidad.getFechaPedido());
    }
    
    public static Pedido parsePedidoEntidadToPedido(PedidoEntidad pedidoEntidad) {
        return new Pedido(pedidoEntidad.getId(), pedidoEntidad.getNombre(), pedidoEntidad.getDireccion(), pedidoEntidad.getTotal(), pedidoEntidad.getEstadoPedido(), pedidoEntidad.getFechaPedido());
    }
}
