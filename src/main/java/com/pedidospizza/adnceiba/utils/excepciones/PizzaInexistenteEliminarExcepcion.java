package com.pedidospizza.adnceiba.utils.excepciones;

public class PizzaInexistenteEliminarExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PizzaInexistenteEliminarExcepcion(String mensaje) {
        super(mensaje);
    }
}
