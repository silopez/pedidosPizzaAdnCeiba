package com.pedidospizza.adnceiba.adicion.dominio.modelo;

import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;
import com.pedidospizza.adnceiba.utils.ValidadorCampos;

import lombok.Getter;

@Getter
public class Adicion {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Integer valor;
	
	private static final Integer TAMANIO_NOMBRE = 50;
	private static final Integer TAMANIO_DESCRIPCION = 250;
	private static final Integer MAXIMO_VALOR_ADICION = 10000;
	private static final Integer MINIMO_VALOR_ADICION = 1000;
		
	public Adicion(Long id, String nombre, String descripcion, Integer valor) {		
		validadoresConstructor(nombre, descripcion, valor);
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public void validadoresConstructor(String nombre, String descripcion, Integer valor) {
		
		ValidadorCampos.validarCamposNulos(nombre, MensajesGeneralesEnum.NOMBRE_ADICION_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(descripcion, MensajesGeneralesEnum.DESCRIPCION_ADICION_OBLIGATORIO.getMensaje());
		ValidadorCampos.validarCamposNulos(valor, MensajesGeneralesEnum.VALOR_ADICION_OBLIGATORIO.getMensaje());
		
		ValidadorCampos.validarCarateresAlfanumericos(nombre, MensajesGeneralesEnum.ADICION_NOMBRE_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		ValidadorCampos.validarTamanioCadena(nombre, TAMANIO_NOMBRE, MensajesGeneralesEnum.ADICION_NOMBRE_MAXIMO_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarCarateresAlfanumericos(descripcion, MensajesGeneralesEnum.ADICION_DESCRIPCION_SOLO_VALORES_ALFANUMERICOS.getMensaje());
		ValidadorCampos.validarTamanioCadena(descripcion, TAMANIO_DESCRIPCION, MensajesGeneralesEnum.ADICION_DESCRIPCION_MAXIMO_DOSCIENTOS_CINCUENTA_CARACTERES.getMensaje());
		
		ValidadorCampos.validarMaximoEntero(valor, MAXIMO_VALOR_ADICION, MensajesGeneralesEnum.VALOR_MAXIMO_ADICION.getMensaje());
		ValidadorCampos.validarMinimoEntero(valor, MINIMO_VALOR_ADICION, MensajesGeneralesEnum.VALOR_MINIMO_ADICION.getMensaje());
		
    }
	 
}
