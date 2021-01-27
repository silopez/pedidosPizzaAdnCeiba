package com.pedidospizza.adnceiba.testdatabuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;

public class AdicionTestDataBuilder {

	private static final Long ID = 1L;
    private static final String NOMBRE = "Queso";
    private static final String DESCRIPCION = "Delicioso queso parmesano";
    private static final Integer VALOR = 5000;
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pepperoni";
    private static final String DESCRIPCION_TEST2 = "Delicioso pepperoni";
    private static final Integer VALOR_TEST2 = 4000;

    private static final Long ID_TEST3 = 1L;
    private static final String NOMBRE_TEST3 = "Piña";
    private static final String DESCRIPCION_TEST3 = "Deliciosa piña";
    private static final Integer VALOR_TEST3 = 6000;
    
    private Long id;
    private String nombre;
    private String descricion;
    private Integer valor;
    
    private List<AdicionDto> listaAdicionesDto = new ArrayList<>();

    public AdicionTestDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.descricion = DESCRIPCION;
        this.valor = VALOR;
    }


    public Adicion build() {
        return new Adicion(id, nombre, descricion, valor);
    }
    
    public List<AdicionDto> buildAllAdicion() {
        AdicionDto adicion1 =  new AdicionDto(id, nombre, descricion, valor);
        AdicionDto adicion2 =  new AdicionDto(ID_TEST2, NOMBRE_TEST2, DESCRIPCION_TEST2, VALOR_TEST2);
        AdicionDto adicion3 =  new AdicionDto(ID_TEST3, NOMBRE_TEST3, DESCRIPCION_TEST3, VALOR_TEST3);
        
        listaAdicionesDto.add(adicion1);
        listaAdicionesDto.add(adicion2);
        listaAdicionesDto.add(adicion3);
        
        return listaAdicionesDto;
    }
    
	
	
}
