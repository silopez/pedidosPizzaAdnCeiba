package com.pedidospizza.adnceiba.pizza.aplicacion.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaComando {

	private Long id;
	private String nombre;
	private String tipo;
	private Integer valor;
	
	public PizzaComando() {}
	
	public PizzaComando(String nombre, String tipo, Integer valor) {		
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public PizzaComando(Long id, String nombre, String tipo, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
}
