package com.pedidospizza.adnceiba.utils.excepciones;

public class NoExistenPizzaEnPedidoExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public NoExistenPizzaEnPedidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
