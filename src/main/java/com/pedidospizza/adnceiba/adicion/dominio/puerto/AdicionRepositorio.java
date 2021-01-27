package com.pedidospizza.adnceiba.adicion.dominio.puerto;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;

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
    void actualizar(Long id);

    /**
     * Nos permite eliminar una adicion creada anteriormente
     * @param id
     */
    void eliminar(Long id);
}
