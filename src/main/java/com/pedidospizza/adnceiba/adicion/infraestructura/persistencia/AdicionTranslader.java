package com.pedidospizza.adnceiba.adicion.infraestructura.persistencia;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.entidad.AdicionEntidad;

public class AdicionTranslader {

	public AdicionTranslader() {
    }

    public static AdicionEntidad parseAdicionToEntidad(Adicion adicion) {
        AdicionEntidad adicionEntidad = new AdicionEntidad();
        adicionEntidad.setNombre(adicion.getNombre());
        adicionEntidad.setDescripcion(adicion.getDescripcion());
        adicionEntidad.setValor(adicion.getValor());
        return adicionEntidad;
    }

    public static AdicionDto parseAdicionToDto(AdicionEntidad adicionEntidad) {
        return new AdicionDto(adicionEntidad.getId(), adicionEntidad.getNombre(), adicionEntidad.getDescripcion(), adicionEntidad.getValor());
    }
	
}
