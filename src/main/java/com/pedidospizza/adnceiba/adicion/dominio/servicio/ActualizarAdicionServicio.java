package com.pedidospizza.adnceiba.adicion.dominio.servicio;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;

public class ActualizarAdicionServicio {
	
	private final AdicionRepositorio adicionRepositorio;

    public ActualizarAdicionServicio(AdicionRepositorio adicionRepositorio) {
        this.adicionRepositorio = adicionRepositorio;
    }

    public Adicion ejecutar(Adicion adicion) {
        return this.adicionRepositorio.actualizar(adicion);
    }
}
