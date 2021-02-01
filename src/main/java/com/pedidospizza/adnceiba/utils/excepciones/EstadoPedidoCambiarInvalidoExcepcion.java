package com.pedidospizza.adnceiba.utils.excepciones;

public class EstadoPedidoCambiarInvalidoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public EstadoPedidoCambiarInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
