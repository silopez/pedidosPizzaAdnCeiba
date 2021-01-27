package com.pedidospizza.adnceiba.pizza.aplicacion.comando;

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
