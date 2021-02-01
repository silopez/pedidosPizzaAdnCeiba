package com.pedidospizza.adnceiba.utils.excepciones;

public class InvalidoSoloAlfaNumericosExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public InvalidoSoloAlfaNumericosExcepcion(String mensaje) {
        super(mensaje);
    }
	
}
