package com.pedidospizza.adnceiba.adicion.dominio.modelo;

public class Adicion {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Integer valor;
	
	public Adicion() {}
		
	public Adicion(Long id, String nombre, String descripcion, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	 
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Integer getValor() {
		return valor;
	}
}
