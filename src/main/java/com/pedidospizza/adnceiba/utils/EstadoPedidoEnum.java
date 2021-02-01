package com.pedidospizza.adnceiba.utils;

import lombok.Getter;

@Getter
public enum EstadoPedidoEnum {
	RECIBIDO(1),
    EN_PREPARACION(2),
    EN_CAMINO(3),
    ENTREGADO(4),
    CANCELADO(5);
	
	private final int id;
	
	EstadoPedidoEnum(int id){
		this.id = id;
	}

}
