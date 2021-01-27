package com.pedidospizza.adnceiba.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.pizza.aplicacion.fabrica.PizzaFabrica;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;

public class PizzaTestDataBuilder {
	
	private static final Long ID_TEST1 = 2L;
    private static final String NOMBRE_TEST1 = "Pizza mexicana";
    private static final String TIPO_TEST1 = "Deliciosa pizza mexicana con jalapeños y carne molida";
    private static final Integer VALOR_TEST1 = 40000;
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pizza mexicana";
    private static final String TIPO_TEST2 = "Deliciosa pizza mexicana con jalapeños y carne molida";
    private static final Integer VALOR_TEST2 = 40000;

    private static final Long ID_TEST3 = 1L;
    private static final String NOMBRE_TEST3 = "Pizza paisa";
    private static final String TIPO_TEST3 = "Deliciosa pizza con maicitos, maduro y chicharron";
    private static final Integer VALOR_TEST3 = 60000;
    
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
    	PizzaDto pizza1 =  new PizzaDto(id, nombre, tipo, valor);
    	PizzaDto pizza2 =  new PizzaDto(ID_TEST2, NOMBRE_TEST2, TIPO_TEST2, VALOR_TEST2);
    	PizzaDto pizza3 =  new PizzaDto(ID_TEST3, NOMBRE_TEST3, TIPO_TEST3, VALOR_TEST3);
        
    	listaPizzasDto.add(pizza1);
    	listaPizzasDto.add(pizza2);
    	listaPizzasDto.add(pizza3);
        
        return listaPizzasDto;
    }
}
