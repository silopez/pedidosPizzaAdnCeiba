package com.pedidospizza.adnceiba.pizza.dominio.modelo;

import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;
import com.pedidospizza.adnceiba.utils.ValidadorCampos;

import lombok.Getter;

@Getter
public class Pizza {
	
	private Long id;
	private String nombre;
	private String tipo;
	private Integer valor;
	
	private static final Integer TAMANIO_NOMBRE = 50;
	private static final Integer TAMANIO_TIPO = 250;
	private static final Integer MAXIMO_VALOR_PIZZA = 20000;
	private static final Integer MINIMO_VALOR_PIZZA = 10000;
	
	public Pizza(String nombre, String tipo, Integer valor) {
		
		validadoresConstructor(nombre, tipo, valor);
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Pizza(Long id, String nombre, String tipo, Integer valor) {	
		
		validadoresConstructor(nombre, tipo, valor);
		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public void validadoresConstructor(String nombre, String tipo, Integer valor) {
		
		ValidadorCampos.validarCamposNulos(nombre, MensajesGeneralesEnum.NOMBRE_PIZZA_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(tipo, MensajesGeneralesEnum.TIPO_PIZZA_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(valor, MensajesGeneralesEnum.VALOR_PIZZA_OBLIGATORIO.getMensaje());
		
		ValidadorCampos.validarCarateresAlfanumericos(nombre, MensajesGeneralesEnum.NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		ValidadorCampos.validarTamanioCadena(nombre, TAMANIO_NOMBRE, MensajesGeneralesEnum.NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarCarateresAlfanumericos(tipo, MensajesGeneralesEnum.TIPO_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		ValidadorCampos.validarTamanioCadena(tipo, TAMANIO_TIPO, MensajesGeneralesEnum.TIPO_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarMaximoEntero(valor, MAXIMO_VALOR_PIZZA, MensajesGeneralesEnum.VALOR_MAXIMO_PIZZA.getMensaje());
		ValidadorCampos.validarMinimoEntero(valor, MINIMO_VALOR_PIZZA, MensajesGeneralesEnum.VALOR_MINIMO_PIZZA.getMensaje());
		
    }
	
}
