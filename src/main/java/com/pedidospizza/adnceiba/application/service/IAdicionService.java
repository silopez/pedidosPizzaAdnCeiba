package com.pedidospizza.adnceiba.application.service;

import java.util.List;

import com.pedidospizza.adnceiba.application.dto.AdicionDTO;
import com.pedidospizza.adnceiba.domain.entity.Adicion;


public interface IAdicionService {

	public List<AdicionDTO> obtenerAdiciones();
	
	public String guardar(AdicionDTO adicion) throws Exception;
	
	public void eliminarAdicion(Long id);

	public Adicion buscarAdicionNombre(String nombre);

	public Adicion  buscarAdicion(Long id);
	
}

