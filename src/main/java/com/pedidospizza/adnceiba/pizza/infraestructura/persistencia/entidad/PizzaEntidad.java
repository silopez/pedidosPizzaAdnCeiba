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
}
