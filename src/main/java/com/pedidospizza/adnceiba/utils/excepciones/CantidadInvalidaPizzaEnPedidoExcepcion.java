package com.pedidospizza.adnceiba.utils.excepciones;

public class CantidadInvalidaPizzaEnPedidoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public CantidadInvalidaPizzaEnPedidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
