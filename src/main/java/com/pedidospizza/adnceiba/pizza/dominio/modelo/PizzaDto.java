package com.pedidospizza.adnceiba.pizza.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDto {
	
	private Long id;
	private String nombre;
	private String tipo;
	private Integer valor;
	
	public PizzaDto(Long id, String nombre, String tipo, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	 
}
