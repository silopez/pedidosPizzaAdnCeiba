package com.pedidospizza.adnceiba.adicion.aplicacion.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionComando {

	private Long id;
	private String nombre;
	private String descripcion;
	private Integer valor;
	
	public AdicionComando() {}
	
	public AdicionComando(Long id, String nombre, String descripcion, Integer valor) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
}
