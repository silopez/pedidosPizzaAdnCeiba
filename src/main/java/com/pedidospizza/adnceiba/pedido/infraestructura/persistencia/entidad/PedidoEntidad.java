package com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

@Entity(name = "pedidos")
@NamedQuery(name="Pedido.obtenerTodos" , query="SELECT ans FROM pedidos ans")
public class PedidoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "direccion", length = 250)
	private String direccion;
	
	@Column(name = "total")
	private Integer total;
	
	@Column(name = "estado_pedido", length = 50)
	@Enumerated(EnumType.STRING)
	private EstadoPedidoEnum estadoPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public EstadoPedidoEnum getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedidoEnum estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
}
