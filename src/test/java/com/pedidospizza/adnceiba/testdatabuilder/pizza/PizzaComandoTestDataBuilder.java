package com.pedidospizza.adnceiba.testdatabuilder.pizza;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;

public class PizzaComandoTestDataBuilder {
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pizza mex";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana";
    private static final Integer VALOR_TEST1 = 11000;
    
    
    private Long id;
    private String nombre;
    private String tipo;
    private Integer valor;
 

    public PizzaComandoTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.tipo = TIPO_TEST1;
        this.valor = VALOR_TEST1;
    }


    public PizzaComando build() {
        return new PizzaComando(id, nombre, tipo, valor);
    }
}
