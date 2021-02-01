package com.pedidospizza.adnceiba.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pedidospizza.adnceiba.utils.excepciones.CampoObligatorioExcepcion;
import com.pedidospizza.adnceiba.utils.excepciones.InvalidoMaximoCincuentaCaracteres;
import com.pedidospizza.adnceiba.utils.excepciones.InvalidoSoloAlfaNumericosExcepcion;

public class ValidadorCampos {
	
	private static final String EXPRESION_REGULAR_ALFANUMERICOS = "^[a-zA-Z\\ ������������\\s]*$";
	
	private ValidadorCampos() {}

    public static void validarCamposNulos(Object campoRevisar, String mensajeError){
        if(campoRevisar == null){
            throw new CampoObligatorioExcepcion(mensajeError);
        }
    }
    
    public static void validarCarateresAlfanumericos(String campoRevisar, String mensajeError) {
        
		Pattern pat = Pattern.compile(EXPRESION_REGULAR_ALFANUMERICOS);
		Matcher mat = pat.matcher(campoRevisar);
		Boolean resultado = mat.find();
        if (resultado) {
            System.out.println("bueno");
        }else {
        	System.out.println("malo " + campoRevisar );
        	throw new InvalidoSoloAlfaNumericosExcepcion(mensajeError);
        }
    }
	
	public static void validarTamanioCadena(String campoRevisar, Integer cantidad, String mensajeError) {
		if(campoRevisar.length()>cantidad) {
			throw new InvalidoMaximoCincuentaCaracteres(mensajeError);
		}
    }

	public static void validarMaximoEntero(Integer valor, Integer maximoValor, String mensajeError) {
		if(valor>maximoValor) {
			throw new InvalidoMaximoCincuentaCaracteres(mensajeError);
		}
	}
	
	public static void validarMinimoEntero(Integer valor, Integer minimoValor, String mensajeError) {
		if(valor<minimoValor) {
			throw new InvalidoMaximoCincuentaCaracteres(mensajeError);
		}
	}
}
