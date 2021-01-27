package com.pedidospizza.adnceiba.adicion.dominio.puerto;

import java.util.List;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;

public interface AdicionDao {
	
	/**
     * Permite consultar todos los las adiciones para las pizzas
     * @return Lista de Lista de Adiciones
     */
    List<AdicionDto> getAdiciones();

}
