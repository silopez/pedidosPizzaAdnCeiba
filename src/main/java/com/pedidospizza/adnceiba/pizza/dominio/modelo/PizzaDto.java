package com.pedidospizza.adnceiba.pizza.dominio.modelo;

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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
