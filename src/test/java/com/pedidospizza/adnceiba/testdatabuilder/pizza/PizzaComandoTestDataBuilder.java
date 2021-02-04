package com.pedidospizza.adnceiba.testdatabuilder.pizza;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;

public class PizzaComandoTestDataBuilder {
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pizza mex";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana";
    private static final Integer VALOR_TEST1 = 11000;
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pizza mex";
    private static final String TIPO_TEST2 = "Deliciosa pizza mexicana";
    private static final Integer VALOR_TEST2 = 11000;
    
    private static final Long ID_3 = 3L;
    private static final String NOMBRE_3 = "Queso dos con mas de cincuenta caractes para que salga la excepcion";
    private static final String TIPO_3 = "Delicioso queso parmesano  ";
    private static final Integer VALOR_3 = 5000;
    
    
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
    
    public PizzaComando build2() {
        return new PizzaComando(ID_TEST2, NOMBRE_TEST2, TIPO_TEST2, VALOR_TEST2);
    }
    
    public PizzaComando buildExcepcion() {
        return new PizzaComando(ID_3, NOMBRE_3, TIPO_3, VALOR_3);
    }
}
