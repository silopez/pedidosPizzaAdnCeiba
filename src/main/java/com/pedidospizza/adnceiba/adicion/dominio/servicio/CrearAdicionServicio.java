package com.pedidospizza.adnceiba.adicion.dominio.servicio;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;


public class CrearAdicionServicio {

	private final AdicionRepositorio adicionRepositorio;

    public CrearAdicionServicio(AdicionRepositorio adicionRepositorio) {
        this.adicionRepositorio = adicionRepositorio;
    }

    public Adicion crear(Adicion adicion) {
        return this.adicionRepositorio.crear(adicion);
    }
}
