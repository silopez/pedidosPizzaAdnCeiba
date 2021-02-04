package com.pedidospizza.adnceiba.testdatabuilder.adicion;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;

public class AdicionTestDataBuilder {

	private static final Long ID = 1L;
    private static final String NOMBRE = "Queso";
    private static final String DESCRIPCION = "Delicioso queso parmesano";
    private static final Integer VALOR = 5000;
    
    private static final Long ID_2 = 1L;
    private static final String NOMBRE_2 = "Queso dos";
    private static final String DESCRIPCION_2 = "Delicioso queso parmesano";
    private static final Integer VALOR_2 = 5000;
    
    private static final String NOMBRE_NO_ALFANUMERICO = "Queso dos #";
    private static final String DESCRIPCION_NO_ALFANUMERICO = "Delicioso queso parmesano#";
    
    private static final String NOMBRE_TAMANIO_MAS_50 = "Queso dos prueba para sobrepasar la cantidad de caracteres que son requeridos";
    private static final String DESCRIPCION_TAMANIO_MAS_250 = "Delicioso queso parmesano Queso dos prueba para sobrepasar la cantidad de caracteres que son requeridos Queso dos prueba para sobrepasar la cantidad de caracteres que son requeridos Queso dos prueba para sobrepasar la cantidad de caracteres que son requeridosQueso dos prueba para sobrepasar la cantidad de caracteres que son requeridos";
        
    private static final Integer VALOR_MININO = 500;
    private static final Integer VALOR_MAXIMO = 50000;
    
    private Long id;
    private String nombre;
    private String descricion;
    private Integer valor;

    public AdicionTestDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.descricion = DESCRIPCION;
        this.valor = VALOR;
    }


    public Adicion build() {
        return new Adicion(id, nombre, descricion, valor);
    }
    
    public Adicion buildNulloNombre() {
        return new Adicion(ID_2, null, DESCRIPCION_2, VALOR_2);
    }
    
    public Adicion buildNulloDescripcion() {
        return new Adicion(ID_2, NOMBRE_2, null, VALOR_2);
    }
    
    public Adicion buildNulloValor() {
        return new Adicion(ID_2, NOMBRE_2, DESCRIPCION_2, null);
    }
    
    public Adicion buildNoAlfanumericoNombre() {
		return new Adicion(ID_2, NOMBRE_NO_ALFANUMERICO, DESCRIPCION_2, VALOR_2);
	}

	public Adicion buildNoAlfanumericoDescripcion() {
		return new Adicion(ID_2, NOMBRE_2, DESCRIPCION_NO_ALFANUMERICO, VALOR_2);
	}

	public Adicion buildTamanioNombre() {
		return new Adicion(ID_2, NOMBRE_TAMANIO_MAS_50, DESCRIPCION_2, VALOR_2);
	}
	
	public Adicion buildTamanioDescripcion() {
		return new Adicion(ID_2, NOMBRE_2, DESCRIPCION_TAMANIO_MAS_250, VALOR_2);
	}

	public Adicion buildValorMinimo() {
		return new Adicion(ID_2, NOMBRE_2, DESCRIPCION_2, VALOR_MININO);
	}

	public Adicion buildValorMaximo() {
		return new Adicion(ID_2, NOMBRE_2, DESCRIPCION_2, VALOR_MAXIMO);		
	}
    	
}
