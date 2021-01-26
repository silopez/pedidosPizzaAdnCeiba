package com.pedidospizza.adnceiba.infraestructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.application.dto.AdicionDTO;
import com.pedidospizza.adnceiba.application.service.IAdicionService;
import com.pedidospizza.adnceiba.application.util.MessageUtil;
import com.pedidospizza.adnceiba.domain.entity.Adicion;


@RestController
@RequestMapping("/api/adicion")
public class AdicionRestController {
	
	private static final String RESPUESTA = "respuesta";
	
	@Autowired
	private IAdicionService adicionService;
	
	@GetMapping("/listaAdiciones")
	@ResponseStatus(HttpStatus.OK)
	public List<AdicionDTO> obtenerAdiciones(){
		return adicionService.obtenerAdiciones();
	}
	
	@GetMapping("/buscarAdicion/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> obtenerAdicion(@PathVariable Long id){
		Map<String, Object> respuesta = new HashMap<>();
		
		try {
			Adicion adicionEncontrada = adicionService.buscarAdicion(id);
			
			if(adicionEncontrada == null) {	
				respuesta.put(RESPUESTA, MessageUtil.ADICION_NO_EXISTENTE.getMensaje());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(adicionEncontrada);
		} catch (DataAccessException e) {
			respuesta.put(RESPUESTA, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
		}			
		
	}
	
	@PostMapping("/guardarAdicion")
	public ResponseEntity<Object> guardar(@RequestBody AdicionDTO adicion){
		
		Map<String, String> respuesta = new HashMap<>();
		
		try {
			String mensajeExito = adicionService.guardar(adicion);
			respuesta.put(RESPUESTA, mensajeExito);
		} catch (Exception e) {
			respuesta.put(RESPUESTA, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
		}			
		
		return ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
	
	@DeleteMapping("/eliminarAdicion/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			adicionService.eliminarAdicion(id);
			
			response.put(RESPUESTA, MessageUtil.ADICION_ELIMINADA_EXITOSAMENTE.getMensaje());
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}catch (DataAccessException e) {
			response.put(RESPUESTA, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
	
}

