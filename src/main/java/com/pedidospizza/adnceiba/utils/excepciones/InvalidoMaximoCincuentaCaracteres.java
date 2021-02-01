package com.pedidospizza.adnceiba.utils.excepciones;

public class InvalidoMaximoCincuentaCaracteres extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public InvalidoMaximoCincuentaCaracteres(String mensaje) {
        super(mensaje);
    }

}
