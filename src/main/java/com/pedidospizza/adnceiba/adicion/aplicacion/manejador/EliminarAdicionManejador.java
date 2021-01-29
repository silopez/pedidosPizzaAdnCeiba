package com.pedidospizza.adnceiba.adicion.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.adicion.dominio.servicio.EliminarAdicionServicio;

@Component
public class EliminarAdicionManejador {
	
	private final EliminarAdicionServicio eliminarAdicionServicio;

    public EliminarAdicionManejador(EliminarAdicionServicio eliminarAdicionServicio) {
        this.eliminarAdicionServicio = eliminarAdicionServicio;
    }

    @Transactional
    public void ejecutar(Long idPizza) {
    	eliminarAdicionServicio.ejecutar(idPizza);
    }

}
