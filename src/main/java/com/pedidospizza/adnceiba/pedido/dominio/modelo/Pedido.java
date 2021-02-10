package com.pedidospizza.adnceiba.pedido.dominio.modelo;

import java.util.Date;

import com.pedidospizza.adnceiba.pedido.dominio.enums.EstadoPedidoEnum;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;
import com.pedidospizza.adnceiba.utils.ValidadorCampos;

import lombok.Getter;

@Getter
public class Pedido {

	private Long id;
	private String nombre;
	private String direccion;
	private Integer total;
	private EstadoPedidoEnum estadoPedido;
	private Date fechaPedido;
	
	private static final Integer TAMANIO_NOMBRE_PEDIDO = 50;
	private static final Integer TAMANIO_DIRECCION_PEDIDO= 250;
	private static final Integer MINIMO_VALOR_PEDIDO = 1000;

	public Pedido(Long id, String nombre, String direccion, Integer total, EstadoPedidoEnum estadoPedido, Date fechaPedido) {
		
		ValidadorCampos.validarCamposNulos(nombre, MensajesGeneralesEnum.NOMBRE_PEDIDO_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(direccion, MensajesGeneralesEnum.DIRECCION_PEDIDO_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(total, MensajesGeneralesEnum.TOTAL_PEDIDO_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(estadoPedido, MensajesGeneralesEnum.ESTADO_PEDIDO_PEDIDO_OBLIGATORIO.getMensaje());
		
		ValidadorCampos.validarCarateresAlfanumericos(nombre, MensajesGeneralesEnum.PEDIDO_NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		ValidadorCampos.validarTamanioCadena(nombre, TAMANIO_NOMBRE_PEDIDO, MensajesGeneralesEnum.PEDIDO_NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarTamanioCadena(direccion, TAMANIO_DIRECCION_PEDIDO, MensajesGeneralesEnum.PEDIDO_DIRECCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarMinimoEntero(total, MINIMO_VALOR_PEDIDO, MensajesGeneralesEnum.VALOR_MINIMO_PEDIDO.getMensaje());
		
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.total = total;
		this.estadoPedido = estadoPedido;
		this.fechaPedido = fechaPedido;
	}	
}
