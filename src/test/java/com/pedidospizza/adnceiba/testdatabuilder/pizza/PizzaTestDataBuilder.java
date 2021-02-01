package com.pedidospizza.adnceiba.testdatabuilder.pizza;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;

public class PizzaTestDataBuilder {
	
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pizza mexicana";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana con jalapeños y carne molida";
    private static final Integer VALOR_TEST1 = 14000;
    
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
 
}
