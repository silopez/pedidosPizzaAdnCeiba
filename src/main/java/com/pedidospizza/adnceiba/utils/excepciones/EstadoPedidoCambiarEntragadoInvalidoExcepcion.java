package com.pedidospizza.adnceiba.utils.excepciones;

public class EstadoPedidoCambiarEntragadoInvalidoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public EstadoPedidoCambiarEntragadoInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
