package com.pedidospizza.adnceiba.pizza.infraestructura.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ActualizarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ConsultarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.CrearPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.EliminarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/pizzas")
public class PizzaControlador {

	private final CrearPizzaManejador crearPizzaManejador;
    private final ConsultarPizzaManejador consultarPizzaManejador;
    private final ActualizarPizzaManejador actualizarPizzaManejador;
    private final EliminarPizzaManejador eliminarPizzaManejador;
    
    private static final Logger LOGGER = Logger.getLogger(PizzaControlador.class.getName());
    
    private static final String MENSAJE = "mensaje";
    private static final String PIZZA = "pizza";

    public PizzaControlador(CrearPizzaManejador crearPizzaManejador, ConsultarPizzaManejador consultarPizzaManejador, ActualizarPizzaManejador actualizarPizzaManejador, EliminarPizzaManejador eliminarPizzaManejador) {
        this.crearPizzaManejador = crearPizzaManejador;
        this.consultarPizzaManejador = consultarPizzaManejador;
        this.actualizarPizzaManejador = actualizarPizzaManejador;
        this.eliminarPizzaManejador = eliminarPizzaManejador;
    }

    @PostMapping
    public ResponseEntity<?> crearPizza(@RequestBody PizzaComando pizzaComando) {
    	
    	Pizza pizza = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try {
        	pizza = crearPizzaManejador.ejecutar(pizzaComando);
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage()); 
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.PIZZA_CREADA_EXITOSAMENTE.getMensaje());
        response.put(PIZZA, pizza);
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PizzaDto> obtenerPizza(){
        return consultarPizzaManejador.obtenerTodasPizzas();
    }
    
    @PutMapping
    public ResponseEntity<?>  actualizarPizza(@RequestBody PizzaComando pizzaComando) {
    	
    	Pizza pizza = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try {
        	pizza = actualizarPizzaManejador.ejecutar(pizzaComando);
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage());  // exception is logged
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.PIZZA_EDITADA_EXITOSAMENTE.getMensaje());
        response.put(PIZZA, pizza);
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPizza(@PathVariable Long id) {
    	       
        Map<String, Object> response = new HashMap<>();
        
        try {
        	eliminarPizzaManejador.ejecutar(id);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.PIZZA_ELIMINADA_EXITOSAMENTE.getMensaje());
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
    	
    	 
    }
    
}
