package com.pedidospizza.adnceiba.adicion.dominio.puerto;

import java.util.List;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;

public interface AdicionRepositorio {
	
	/**
     * Nos permite crear un adiciones
     * @param adicion
     * @return id adicion
     */
    Adicion crear(Adicion adicion);

    /**
     * Nos permite actualizar un adicion creada anteriormente
     * @param id
     */
    Adicion actualizar(Adicion adicion);

    /**
     * Nos permite eliminar una adicion creada anteriormente
     * @param id
     */
    void eliminar(Long id);
    
}
