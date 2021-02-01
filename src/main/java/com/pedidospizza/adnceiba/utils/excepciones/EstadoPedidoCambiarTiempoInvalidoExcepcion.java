package com.pedidospizza.adnceiba.utils.excepciones;

public class EstadoPedidoCambiarTiempoInvalidoExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public EstadoPedidoCambiarTiempoInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
