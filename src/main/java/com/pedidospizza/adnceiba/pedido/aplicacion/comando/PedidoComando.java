package com.pedidospizza.adnceiba.pedido.aplicacion.comando;

import java.util.Date;

import com.pedidospizza.adnceiba.pedido.dominio.enums.EstadoPedidoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoComando {

	private Long id;
	private String nombre;
	private String direccion;
	private Integer total;
	private EstadoPedidoEnum estadoPedido;
	private Date fechaPedido;
	
	public PedidoComando() {}

	public PedidoComando(Long id, String nombre, String direccion, Integer total, EstadoPedidoEnum estadoPedido, Date fechaPedido) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.total = total;
		this.estadoPedido = estadoPedido;
		this.fechaPedido = fechaPedido;
	}	
}
