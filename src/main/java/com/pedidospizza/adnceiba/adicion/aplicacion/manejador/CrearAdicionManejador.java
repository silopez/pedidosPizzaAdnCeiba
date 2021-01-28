package com.pedidospizza.adnceiba.adicion.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.aplicacion.fabrica.AdicionFabrica;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.CrearAdicionServicio;

@Component
public class CrearAdicionManejador {
	
	private final CrearAdicionServicio crearAdicionServicio;
    private final AdicionFabrica adicionFabrica;

    public CrearAdicionManejador(CrearAdicionServicio crearAdicionServicio, AdicionFabrica adicionFabrica) {
        this.crearAdicionServicio = crearAdicionServicio;
        this.adicionFabrica = adicionFabrica;
    }

    @Transactional
    public Adicion ejecutar(AdicionComando adicionComando) {
    	Adicion adicion = adicionFabrica.crearAdicion(adicionComando);
        return crearAdicionServicio.crear(adicion);
    }
}
