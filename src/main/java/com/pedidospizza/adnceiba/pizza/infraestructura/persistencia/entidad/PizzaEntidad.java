package com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity(name = "pizzas")
@NamedQuery(name="Pizza.obtenerTodas" , query="SELECT ans FROM pizzas ans")
@Data
public class PizzaEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "tipo", length = 250)
	private String tipo;
	
	@Column(name = "valor")
	private Integer valor;
	
	public PizzaEntidad() {}
	
	public PizzaEntidad(Long id, String nombre, String tipo, Integer valor) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public PizzaEntidad(String nombre, String tipo, Integer valor) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
}
