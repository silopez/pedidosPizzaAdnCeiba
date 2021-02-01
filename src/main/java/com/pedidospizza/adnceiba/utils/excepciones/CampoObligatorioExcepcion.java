package com.pedidospizza.adnceiba.utils.excepciones;

public class CampoObligatorioExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public CampoObligatorioExcepcion(String mensaje) {
        super(mensaje);
    }

}
