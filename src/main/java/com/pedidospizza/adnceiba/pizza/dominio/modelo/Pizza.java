package com.pedidospizza.adnceiba.pizza.dominio.modelo;

import lombok.Getter;

@Getter
public class Pizza {
	
	private Long id;
	private String nombre;
	private String tipo;
	private Integer valor;
	
	public Pizza(String nombre, String tipo, Integer valor) {		
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Pizza(Long id, String nombre, String tipo, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
}
