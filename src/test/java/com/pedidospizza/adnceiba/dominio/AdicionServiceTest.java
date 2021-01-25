package com.pedidospizza.adnceiba.dominio;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pedidospizza.adnceiba.application.dto.AdicionDTO;
import com.pedidospizza.adnceiba.application.service.AdicionServiceImpl;
import com.pedidospizza.adnceiba.application.service.IAdicionService;
import com.pedidospizza.adnceiba.domain.entity.Adicion;
import com.pedidospizza.adnceiba.domain.repository.IAdicionRepository;


@RunWith(SpringRunner.class)
public class AdicionServiceTest {
	
	@TestConfiguration
	static class AdicionServiceTestContextConfiguration {
		
		@Bean
		public IAdicionService employeeService() {
            return new AdicionServiceImpl();
        }
	}
	
	@Autowired
    private IAdicionService adicionService;

    @MockBean
    private IAdicionRepository adicionRepository;
    
    private List<Adicion> listaAdiciones = new ArrayList<>();
    
    private List<AdicionDTO> listaAdicionesDTO = new ArrayList<>();
    
    @Before
    public void setUp() throws ParseException {
        Adicion adicion1 = new Adicion("queso", "queso rico", 2000);
        Adicion adicion2 = new Adicion("quesodos", "queso rico dos", 3000);
        listaAdiciones.add(adicion1);
        listaAdiciones.add(adicion2);
        listaAdiciones.forEach(adicion -> {
        	listaAdicionesDTO.add(AdicionDTO.convertirEntidadADTO(adicion));
        });
    }
    
    @Test
    public void obtenerTodosTest() {
        Mockito.when(adicionRepository.findAll()).thenReturn(listaAdiciones);
        List<AdicionDTO> listaAdiciones = adicionService.obtenerAdiciones();
        assertEquals(listaAdiciones.size(),2);
        assertEquals(listaAdiciones.get(0).getNombre(),listaAdicionesDTO.get(0).getNombre());
        assertEquals(listaAdiciones.get(0).getDescripcion(),listaAdicionesDTO.get(0).getDescripcion());
        assertEquals(listaAdiciones.get(1).getValor(),listaAdicionesDTO.get(1).getValor());
    }

}
