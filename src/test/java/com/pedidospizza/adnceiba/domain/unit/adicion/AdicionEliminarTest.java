package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.EliminarAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionTestDataBuilder;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

public class AdicionEliminarTest {
		
	@Test
    public void validarEliminarAdicionNoEncontrada() {
        Adicion adicion = new AdicionTestDataBuilder().build();
        AdicionRepositorio adicionRepositorio = Mockito.mock(AdicionRepositorio.class);
        Mockito.when(adicionRepositorio.bucarEntidad(adicion.getId())).thenReturn(null);
        EliminarAdicionServicio eliminarAdicionServicio = new EliminarAdicionServicio(adicionRepositorio);
        
        try {
        	eliminarAdicionServicio.ejecutar(adicion.getId());
		} catch (Exception e) {
			assertEquals(e.getMessage(), MensajesGeneralesEnum.ADICION_INEXISTENTE_ELIMINAR.getMensaje());
		}
    }
}
