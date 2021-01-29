package com.pedidospizza.adnceiba.adicion.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.aplicacion.fabrica.AdicionFabrica;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ActualizarAdicionServicio;

@Component
public class ActualizarAdicionManejador {

	private final ActualizarAdicionServicio actualizarAdicionServicio;
	private final AdicionFabrica adicionFabrica;

    public ActualizarAdicionManejador(ActualizarAdicionServicio actualizarAdicionServicio, AdicionFabrica adicionFabrica) {
        this.actualizarAdicionServicio = actualizarAdicionServicio;
        this.adicionFabrica = adicionFabrica;
    }

    @Transactional
    public Adicion ejecutar(AdicionComando adicionComando) {
    	Adicion adicion = adicionFabrica.crearAdicion(adicionComando);
        return actualizarAdicionServicio.ejecutar(adicion);
    }
	
}
