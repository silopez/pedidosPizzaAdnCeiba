package com.pedidospizza.adnceiba.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;

public class PizzaTestDataBuilder {
	
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pizza mexicana";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana con jalapeños y carne molida";
    private static final Integer VALOR_TEST1 = 40000;
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pizza paisa";
    private static final String TIPO_TEST2 = "Deliciosa pizza con maicitos, maduro y chicharron";
    private static final Integer VALOR_TEST2 = 40000;
    
    private Long id;
    private String nombre;
    private String tipo;
    private Integer valor;
    
    private List<PizzaDto> listaPizzasDto = new ArrayList<>();

    public PizzaTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.tipo = TIPO_TEST1;
        this.valor = VALOR_TEST1;
    }


    public Pizza build() {
        return new Pizza(id, nombre, tipo, valor);
    }
    
    public List<PizzaDto> buildAllPizza() {
    	PizzaDto pizza1 =  new PizzaDto(ID_TEST1, NOMBRE_TEST1, TIPO_TEST1, VALOR_TEST1);
    	PizzaDto pizza2 =  new PizzaDto(ID_TEST2, NOMBRE_TEST2, TIPO_TEST2, VALOR_TEST2);
        
    	listaPizzasDto.add(pizza1);
    	listaPizzasDto.add(pizza2);
        
        return listaPizzasDto;
    }
}
