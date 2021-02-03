package com.pedidospizza.adnceiba.utils.excepciones;

public class AdicionInexistenteEliminarExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public AdicionInexistenteEliminarExcepcion(String mensaje) {
        super(mensaje);
    }

}
