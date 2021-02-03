package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ActualizarAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionEliminarTest {
		
	@Test
    public void validarActualizarAdicionNoEncontrada() {
        Adicion adicion = new AdicionTestDataBuilder().build();
        AdicionRepositorio adicionRepositorio = Mockito.mock(AdicionRepositorio.class);
        Mockito.when(adicionRepositorio.bucarEntidad(adicion.getId())).thenReturn(null);
        ActualizarAdicionServicio actualizarAdicionServicio = new ActualizarAdicionServicio(adicionRepositorio);
        
        try {
        	actualizarAdicionServicio.ejecutar(adicion);
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_INEXISTENTE_ELIMINAR.getMensaje());
		}
    }
}
