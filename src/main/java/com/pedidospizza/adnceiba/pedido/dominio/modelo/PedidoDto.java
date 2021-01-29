package com.pedidospizza.adnceiba.pedido.dominio.modelo;

import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

import lombok.Getter;

@Getter
public class PedidoDto {

	private Long id;
	private String nombre;
	private String direccion;
	private Integer total;
	private EstadoPedidoEnum estadoPedido;
	
	public PedidoDto() {}

	public PedidoDto(Long id, String nombre, String direccion, Integer total, EstadoPedidoEnum estadoPedido) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.total = total;
		this.estadoPedido = estadoPedido;
	}
}
