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
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
