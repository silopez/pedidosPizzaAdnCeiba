package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.CrearAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;

public class AdicionCrearTest {

	@Test
    public void validarCreacionAdicionCorrecto() {
        Adicion adicion = new AdicionTestDataBuilder().build();
        AdicionRepositorio adicionRepositorio = Mockito.mock(AdicionRepositorio.class);
        Mockito.when(adicionRepositorio.crear(adicion)).thenReturn(adicion);
        CrearAdicionServicio crearAdicionServicio = new CrearAdicionServicio(adicionRepositorio);
        Adicion nuevaAdicionCreada = crearAdicionServicio.crear(adicion);
        assertEquals(nuevaAdicionCreada, adicion);
    }
	
}
