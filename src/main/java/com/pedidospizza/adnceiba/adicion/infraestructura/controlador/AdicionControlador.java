package com.pedidospizza.adnceiba.adicion.infraestructura.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.ActualizarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.ConsultarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.CrearAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.EliminarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/adiciones")
public class AdicionControlador {
	
	private final CrearAdicionManejador crearAdicionManejador;
    private final ConsultarAdicionManejador consultarAdicionManejador;
    private final ActualizarAdicionManejador actualizarAdicionManejador;
    private final EliminarAdicionManejador eliminarAdicionManejador;
    
    private static final String MENSAJE = "mensaje";
    private static final String ADICION = "adicion";

    public AdicionControlador(CrearAdicionManejador crearAdicionManejador, ConsultarAdicionManejador consultarAdicionManejador, ActualizarAdicionManejador actualizarAdicionManejador, EliminarAdicionManejador eliminarAdicionManejador) {
        this.crearAdicionManejador = crearAdicionManejador;
        this.consultarAdicionManejador = consultarAdicionManejador;
        this.actualizarAdicionManejador = actualizarAdicionManejador;
        this.eliminarAdicionManejador = eliminarAdicionManejador;
    }

    @PostMapping
    public ResponseEntity<?> crearAdicion(@RequestBody AdicionComando adicionComando) {
    	
    	Adicion adicion = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try {
        	adicion = crearAdicionManejador.ejecutar(adicionComando);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.ADICION_CREADA_EXITOSAMENTE.getMensaje());
        response.put(ADICION, adicion);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AdicionDto> obtenerAdicion(){
        return consultarAdicionManejador.obtenerTodasAdiciones();
    }
    
    @PutMapping
    public ResponseEntity<?>  actualizarAdicion(@RequestBody AdicionComando adicionComando) {
    	
    	Adicion adicion = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try {
        	adicion = actualizarAdicionManejador.ejecutar(adicionComando);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.ADICION_EDITADA_EXITOSAMENTE.getMensaje());
        response.put(ADICION, adicion);
        
        return new ResponseEntity<>(response, HttpStatus.OK); 
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  eliminarAdicion(@PathVariable Long id) {
    	
    	Map<String, Object> response = new HashMap<>();
        
        try {
        	eliminarAdicionManejador.ejecutar(id);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.ADICION_ELIMINADA_EXITOSAMENTE.getMensaje());
        
        return new ResponseEntity<>(response, HttpStatus.OK); 
    	
    	 
    }

}
