package com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

@Entity(name = "pedidos")
@NamedQuery(name="Pedido.obtenerTodos" , query="SELECT ped FROM pedidos ped")
@NamedQuery(name="Pedido.obtenerPorId" , query="SELECT ped FROM pedidos ped WHERE ped.id = ?1")
@NamedQuery(name="Pedido.actualizarEstado" , query ="UPDATE pedidos ped SET ped.estadoPedido = ?1 WHERE ped.id = ?2")
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
	
	@Column(name = "fecha_pedido")
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

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

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
}
