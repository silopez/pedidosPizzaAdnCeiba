package com.pedidospizza.adnceiba.utils;

import lombok.Getter;

@Getter
public enum MensajesGeneralesEnum {

	/*PIZZA MENSAJES*/
	NOMBRE_SOLO_VALORES_ALFANUMERICOS("El nombre de la pizza solo deben ser valores alfanumericos"),
	NOMBRE_MAXIMO_CINCUENTA_CARACTERES("El nombre de la pizza debe ser maximo 50 caracteres"),
	NOMBRE_PIZZA_OBLIGATORIO("El nombre de la pizza debe ser obligatorio"),
	
	TIPO_SOLO_VALORES_ALFANUMERICOS("El nombre de la pizza solo deben ser valores alfanumericos"),
	TIPO_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES("El nombre de la pizza debe ser maximo 250 caracteres"),
	TIPO_PIZZA_OBLIGATORIO("El tipo de la pizza debe ser obligatorio"),

	VALOR_MAXIMO_PIZZA("El valor maximo de una pizza es de 20.000"),
	VALOR_MINIMO_PIZZA("El valor minimo de una pizza es de 10.000"),
	VALOR_PIZZA_OBLIGATORIO("El valor de la pizza debe ser obligatorio"), 
	
	/*ADICION MENSAJES*/
	ADICION_NOMBRE_SOLO_VALORES_ALFANUMERICOS("El nombre de la Adición solo deben ser valores alfanumericos"),
	ADICION_NOMBRE_MAXIMO_CINCUENTA_CARACTERES("El nombre de la adición debe ser maximo 50 caracteres"),
	NOMBRE_ADICION_OBLIGATORIO("El nombre de la adición debe ser obligatorio"),

	ADICION_DESCRIPCION_SOLO_VALORES_ALFANUMERICOS("La descripción de la adición solo deben ser valores alfanumericos"),
	ADICION_DESCRIPCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES("La descripción de la adición debe ser maximo 250 caracteres"),
	DESCRIPCION_ADICION_OBLIGATORIO("La descripción de la adición debe ser obligatoria"),
	
	VALOR_MAXIMO_ADICION("El valor maximo de una adición es de 10.000"),
	VALOR_MINIMO_ADICION("El valor minimo de una adición es de 1.000"),
	VALOR_ADICION_OBLIGATORIO("El valor de la adición debe ser obligatorio"),
	
	/*PEDIDOS MENSAJES*/
	PEDIDO_NOMBRE_SOLO_VALORES_ALFANUMERICOS("El nombre de la persona que solicita el pedido solo deben ser valores alfanumericos"),
	PEDIDO_NOMBRE_MAXIMO_CINCUENTA_CARACTERES("El nombre de la persona que solicita el pedido debe ser maximo 50 caracteres"),
	NOMBRE_PEDIDO_OBLIGATORIO("El nombre de la persona que solicita el pedido debe ser obligatorio"),

	PEDIDO_DIRECCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES("La dirección del pedido a enviar debe ser maximo 250 caracteres"),
	DIRECCION_PEDIDO_OBLIGATORIO("La dirección del pedido a enviar debe ser obligatoria"),
	
	VALOR_MINIMO_PEDIDO("El valor minimo de una adición es de 20.000"),
	TOTAL_PEDIDO_OBLIGATORIO("El valor deL pedido debe ser obligatorio"),
	
	ESTADO_PEDIDO_PEDIDO_OBLIGATORIO("El estado del pedido es obligatorio"),
	FECHA_PEDIDO_OBLIGATORIO("La fecha del pedido a realizar debe ser obligatorio"), 
	ESTADO_PEDIDO_CAMBIAR_INVALIDO("El estado pedido al que se desea cambiar es anterior al estado actual"), 
	ESTADO_PEDIDO_CANCELADO_TIEMPO_INVALIDO("No es posible cancelar este pedido ya que paso el lapso de tiempo"), 
	ESTADO_PEDIDO_CANCELADO_ENTREGADO_INVALIDO("No es posible cancelar un pedido ya entregado"),
	NO_EXISTE_PIZZA_PEDIDO("En el pedido a realizar no hay pizzas, por favor agregue por lo menos una pizza"), 
	CANTIDAD_INVALIDAD_PIZZA_PEDIDO("Ha excedido la cantidad de pizzas posibles por pedido"), 
	CANTIDAD_INVALIDADO_ADICION_PIZZA("Ha excedido la cantidad de adiciones para la pizza "); 
	
	private final String mensaje;
	
	MensajesGeneralesEnum(String mensaje){
		this.mensaje = mensaje;
	}

}
