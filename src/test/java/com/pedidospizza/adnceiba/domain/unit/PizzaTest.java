package com.pedidospizza.adnceiba.domain.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ConsultarAdicionServicio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.CrearAdicionServicio;
import com.pedidospizza.adnceiba.testdatabuilder.AdicionTestDataBuilder;

public class PizzaTest {
	@Test
    public void validarCreacionPizza() {
        Adicion adicion = new AdicionTestDataBuilder().build();
        AdicionRepositorio adicionRepositorio = Mockito.mock(AdicionRepositorio.class);
        Mockito.when(adicionRepositorio.crear(adicion)).thenReturn(adicion);
        CrearAdicionServicio crearAdicionServicio = new CrearAdicionServicio(adicionRepositorio);
        Adicion nuevaAdicionCreada = crearAdicionServicio.crear(adicion);
        assertEquals(nuevaAdicionCreada, adicion);
    }
	
	@Test
    public void validarlistarTodasAdicion() {
        List<AdicionDto> adiciones = new AdicionTestDataBuilder().buildAllAdicion();
        AdicionDao adicionDao = Mockito.mock(AdicionDao.class);
        Mockito.when(adicionDao.getAdiciones()).thenReturn(adiciones);
        ConsultarAdicionServicio consultarAdicionServicio = new ConsultarAdicionServicio(adicionDao);
        List<AdicionDto> listaAdicionesBuscadas = consultarAdicionServicio.getAllAdiciones();
        assertEquals(listaAdicionesBuscadas, adiciones);
    }
}
