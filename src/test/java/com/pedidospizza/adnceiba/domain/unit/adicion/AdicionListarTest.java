package com.pedidospizza.adnceiba.domain.unit.adicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ConsultarAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.adicion.AdicionDtoTestDataBuilder;

public class AdicionListarTest {
	
	@Test
    public void validarlistarTodasAdicionCorrecto() {
        List<AdicionDto> adiciones = new AdicionDtoTestDataBuilder().buildAllAdicion();
        AdicionDao adicionDao = Mockito.mock(AdicionDao.class);
        Mockito.when(adicionDao.getAdiciones()).thenReturn(adiciones);
        ConsultarAdicionServicio consultarAdicionServicio = new ConsultarAdicionServicio(adicionDao);
        List<AdicionDto> listaAdicionesBuscadas = consultarAdicionServicio.getAllAdiciones();
        assertEquals(listaAdicionesBuscadas, adiciones);
    }

}
