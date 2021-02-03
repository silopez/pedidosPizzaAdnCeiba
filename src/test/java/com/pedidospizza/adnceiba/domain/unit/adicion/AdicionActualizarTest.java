package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ActualizarAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;

public class AdicionActualizarTest {
	@Test
    public void validarActualizarAdicionCorrecto() {
        Adicion adicion = new AdicionTestDataBuilder().build();
        AdicionRepositorio adicionRepositorio = Mockito.mock(AdicionRepositorio.class);
        Mockito.when(adicionRepositorio.actualizar(adicion)).thenReturn(adicion);
        ActualizarAdicionServicio actualizarAdicionServicio = new ActualizarAdicionServicio(adicionRepositorio);
        Adicion adicionActualizada = actualizarAdicionServicio.ejecutar(adicion);
        assertEquals(adicionActualizada, adicion);
    }
}
