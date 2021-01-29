package com.pedidospizza.adnceiba.testdatabuilder.adicion;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;

public class AdicionComandoTestDataBuilder {
	
	private static final Long ID = 1L;
    private static final String NOMBRE = "Queso";
    private static final String DESCRIPCION = "Delicioso queso parmesano";
    private static final Integer VALOR = 5000;
    
    private Long id;
    private String nombre;
    private String descricion;
    private Integer valor;

    public AdicionComandoTestDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.descricion = DESCRIPCION;
        this.valor = VALOR;
    }


    public AdicionComando build() {
        return new AdicionComando(id, nombre, descricion, valor);
    } 

}
