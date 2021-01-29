package com.pedidospizza.adnceiba.adicion.dominio.servicio;

import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.entidad.AdicionEntidad;

public class EliminarAdicionServicio {
	
	private final AdicionRepositorio adicionRepositorio;

    public EliminarAdicionServicio(AdicionRepositorio adicionRepositorio) {
        this.adicionRepositorio = adicionRepositorio;
    }

    public void ejecutar(Long idAdicion) {
    	
    	AdicionEntidad adicionEntidad = adicionRepositorio.bucarEntidad(idAdicion);
    	
    	if(adicionEntidad != null) {
    		adicionRepositorio.eliminar(adicionEntidad);
    	}        
    }
}
