package com.pedidospizza.adnceiba.pedido.dominio.modelo;

import java.util.Date;

import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

import lombok.Getter;

@Getter
public class PedidoDto {

	private Long id;
	private String nombre;
	private String direccion;
	private Integer total;
	private EstadoPedidoEnum estadoPedido;
	private Date fechaPedido;
	
	public PedidoDto() {}

	public PedidoDto(Long id, String nombre, String direccion, Integer total, EstadoPedidoEnum estadoPedido, Date fechaPedido) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.total = total;
		this.estadoPedido = estadoPedido;
		this.fechaPedido = fechaPedido;
	}
}
