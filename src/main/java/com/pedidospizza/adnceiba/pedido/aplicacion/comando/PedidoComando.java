package com.pedidospizza.adnceiba.pedido.aplicacion.comando;

import lombok.Getter;

@Getter
public class PedidoComando {

	private Long id;
	private String nombre;
	private String direccion;
	private Integer total;
	private String estadoPedido;
	
	public PedidoComando() {}

	public PedidoComando(Long id, String nombre, String direccion, Integer total, String estadoPedido) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.total = total;
		this.estadoPedido = estadoPedido;
	}
}
