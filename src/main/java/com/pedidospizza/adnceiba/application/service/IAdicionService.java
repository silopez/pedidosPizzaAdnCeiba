package com.pedidospizza.adnceiba.application.service;

import java.util.List;

import com.pedidospizza.adnceiba.application.dto.AdicionDTO;
import com.pedidospizza.adnceiba.domain.entity.Adicion;


public interface IAdicionService {

	public List<AdicionDTO> obtenerAdiciones();
	
	public String guardar(AdicionDTO adicion) throws Exception;
	
	public Adicion buscarAdicion(String nombre);
	
	public String eliminarAdicion(Long Id);
	
}

