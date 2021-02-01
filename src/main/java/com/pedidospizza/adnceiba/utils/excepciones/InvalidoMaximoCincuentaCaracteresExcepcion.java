package com.pedidospizza.adnceiba.utils.excepciones;

public class InvalidoMaximoCincuentaCaracteresExcepcion extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public InvalidoMaximoCincuentaCaracteresExcepcion(String mensaje) {
        super(mensaje);
    }

}
