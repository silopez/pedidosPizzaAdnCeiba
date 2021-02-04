package com.pedidospizza.adnceiba.testdatabuilder.pizza;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;

public class PizzaTestDataBuilder {
	
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pizza mexicana";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana con jalapeños y carne molida";
    private static final Integer VALOR_TEST1 = 14000;
    
    private static final String NOMBRE_TEST_NO_ALFANUMERICO= "Pizza m$%exicana";
    private static final String TIPO_TEST_NO_ALFANUMERICO= "Pizza m$%exicana";
    private static final String NOMBRE_TEST_TAMANIO= "Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicanaPizza mexicana Pizza mexicana";
    private static final String TIPO_TEST_TAMANIO= "Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicanaPizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicanaPizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicana Pizza mexicanaPizza mexicana Pizza mexicana";
    private static final Integer VALOR_TEST_MINIMO= 1000; 
    private static final Integer VALOR_TEST_MAXIMO= 100000; 
    
    private Long id;
    private String nombre;
    private String tipo;
    private Integer valor;
    

    public PizzaTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.tipo = TIPO_TEST1;
        this.valor = VALOR_TEST1;
    }

    public Pizza build() {
        return new Pizza(id, nombre, tipo, valor);
    }

	public Pizza buildNulloNombre() {
		return new Pizza(id, null, tipo, valor);		
	}

	public Pizza buildNulloDescripcion() {
		return new Pizza(id, nombre, null, valor);	
	}

	public Pizza buildNulloValor() {
		return new Pizza(id, nombre, tipo, null);		
	}

	public Pizza buildNoAlfanumericoNombre() {
		return new Pizza(id, NOMBRE_TEST_NO_ALFANUMERICO, tipo, valor);
	}

	public Pizza buildNoAlfanumericoDescripcion() {
		return new Pizza(id, nombre, TIPO_TEST_NO_ALFANUMERICO, valor);
	}

	public Pizza buildTamanioNombre() {
		return new Pizza(id, NOMBRE_TEST_TAMANIO, tipo, valor);		
	}

	public Pizza buildTamanioDescripcion() {
		return new Pizza(id, nombre, TIPO_TEST_TAMANIO, valor);	
	}

	public Pizza buildValorMinimo() {
		return new Pizza(id, nombre, tipo, VALOR_TEST_MINIMO);	
	}

	public Pizza buildValorMaximo() {
		return new Pizza(id, nombre, tipo, VALOR_TEST_MAXIMO);
	}
 
}
