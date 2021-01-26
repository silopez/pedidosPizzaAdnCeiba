package com.pedidospizza.adnceiba.dominio;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.pedidospizza.adnceiba.application.util.MessageUtil;
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
        assertEquals(2,listaAdiciones.size());
        assertEquals(listaAdiciones.get(0).getNombre(),listaAdicionesDTO.get(0).getNombre());
        assertEquals(listaAdiciones.get(0).getDescripcion(),listaAdicionesDTO.get(0).getDescripcion());
        assertEquals(listaAdiciones.get(1).getValor(),listaAdicionesDTO.get(1).getValor());
    }
    
    @Test
    public void guardarAdicionValorCorrecto() throws Exception {

        Adicion adicion = new Adicion("Jalapeño", "Ricos Jalapeños", 2000);
        AdicionDTO adicionDTO = AdicionDTO.convertirEntidadADTO(adicion);

        Mockito.when(adicionRepository.save(adicion)).thenReturn(null);
        
        String mensajeResultado = adicionService.guardar(adicionDTO);

        assertEquals(MessageUtil.GUARDADO_EXITOSO_ADICION.getMensaje(),mensajeResultado);

    }
    
    @Test
    public void actualizarAdicionValorCorrecto() throws Exception {
    	
    	Adicion adicion = new Adicion(1L, "Quesito", "Rico quesito", 2000);
    	    	
    	Optional<Adicion> adicionOpcional = Optional.of(adicion);
    	
    	

        AdicionDTO adicionDTO = new AdicionDTO(1L, "peperoni", "peperonis ricos y frescos", "3000");

        Mockito.when(adicionRepository.findById(adicionDTO.getId())).thenReturn(adicionOpcional);
        
        Mockito.when(adicionRepository.save(adicion)).thenReturn(null);
        
        String mensajeResultado = adicionService.guardar(adicionDTO);

        assertEquals(MessageUtil.ACTUALIZACION_EXITOSA_ADICION.getMensaje(),mensajeResultado);

    }
    
    @Test
    public void buscarAdicionNombre() throws Exception {
    	
    	String nombre = "Piña";
    	
    	Adicion adicion = new Adicion(1L, "Piña", "Rico piña", 2000);
    	
    	Mockito.when(adicionRepository.findBynombre(nombre)).thenReturn(adicion);
    	
    	Adicion respuestaAdicion = adicionService.buscarAdicionNombre("Piña");
    	
    	assertEquals(adicion.getId(),respuestaAdicion.getId());
    	assertEquals(adicion.getNombre(),respuestaAdicion.getNombre());
    	assertEquals(adicion.getDescripcion(),respuestaAdicion.getDescripcion());
    	assertEquals(adicion.getValor(),respuestaAdicion.getValor());

    }
    
    @Test
    public void eliminarAdicion() throws Exception {
    	
    	Long idAdicion = 1L;
    
    	Mockito.doNothing().when(adicionRepository).deleteById(idAdicion);
    	
    	String resultado = adicionService.eliminarAdicion(idAdicion);
    	
    	assertEquals(MessageUtil.ADICION_ELIMINADA_EXITOSAMENTE.getMensaje(), resultado);
    	
    	
    }

}

