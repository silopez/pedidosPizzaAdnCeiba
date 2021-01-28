package com.pedidospizza.adnceiba.adicion.dominio.modelo;

import lombok.Getter;

@Getter
public class Adicion {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Integer valor;
		
	public Adicion(Long id, String nombre, String descripcion, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	 
}
