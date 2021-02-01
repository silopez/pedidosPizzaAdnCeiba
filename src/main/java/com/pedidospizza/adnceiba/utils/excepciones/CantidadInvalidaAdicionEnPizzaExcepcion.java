package com.pedidospizza.adnceiba.utils.excepciones;

public class CantidadInvalidaAdicionEnPizzaExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public CantidadInvalidaAdicionEnPizzaExcepcion(String mensaje) {
        super(mensaje);
    }
}
