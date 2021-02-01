package com.pedidospizza.adnceiba.testdatabuilder.adicion;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;

public class AdicionComandoTestDataBuilder {
	
	private static final Long ID = 1L;
    private static final String NOMBRE = "Queso";
    private static final String DESCRIPCION = "Delicioso queso parmesano";
    private static final Integer VALOR = 5000;
    
    private static final Long ID_2 = 2L;
    private static final String NOMBRE_2 = "Queso dos";
    private static final String DESCRIPCION_2 = "Delicioso queso parmesano";
    private static final Integer VALOR_2 = 5000;
    
    private Long id;
    private String nombre;
    private String descricion;
    private Integer valor;
    
    private List<AdicionComando> listaAdicionComando = new ArrayList<AdicionComando>();

    public AdicionComandoTestDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.descricion = DESCRIPCION;
        this.valor = VALOR;
    }


    public AdicionComando build() {
        return new AdicionComando(id, nombre, descricion, valor);
    } 
    
    public List<AdicionComando> buildAllAdicionComando() {
    	AdicionComando adicionComando =  new AdicionComando(ID, NOMBRE, DESCRIPCION, VALOR);
    	AdicionComando adicionComando2 =  new AdicionComando(ID_2, NOMBRE_2, DESCRIPCION_2, VALOR_2);
        
    	listaAdicionComando.add(adicionComando);
    	listaAdicionComando.add(adicionComando2);
        
        return listaAdicionComando;
    }

}
