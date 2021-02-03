package com.pedidospizza.adnceiba.pedido.infraestructura.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.manejador.ConsultarPedidoManejador;
import com.pedidospizza.adnceiba.pedido.aplicacion.manejador.CrearPedidoManejador;
import com.pedidospizza.adnceiba.pedido.aplicacion.manejador.ModificarEstadoPedidoManejador;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {
	
	private final CrearPedidoManejador crearPedidoManejador;
    private final ConsultarPedidoManejador consultarPedidoManejador;
    private final ModificarEstadoPedidoManejador modificarEstadoPedidoManejador;

    private static final String MENSAJE = "mensaje";
    private static final String PEDIDO = "pedido";
    
    public PedidoControlador(CrearPedidoManejador crearPedidoManejador, ConsultarPedidoManejador consultarPedidoManejador, ModificarEstadoPedidoManejador modificarEstadoPedidoManejador) {
        this.crearPedidoManejador = crearPedidoManejador;
        this.consultarPedidoManejador = consultarPedidoManejador;
        this.modificarEstadoPedidoManejador = modificarEstadoPedidoManejador;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearPedido(@RequestBody DetallePedidoComando detallePedidoComando) {
    	
    	Pedido pedido = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try {
        	pedido = crearPedidoManejador.ejecutar(detallePedidoComando);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.PEDIDO_CREADO_EXITOSAMENTE.getMensaje());
        response.put(PEDIDO, pedido);
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PedidoDto> obtenerPedido(){
        return consultarPedidoManejador.obtenerTodosPedidos();
    }
    
    @PutMapping("/{id}/{estadoPedido}")
    public ResponseEntity<?> modificarEstado(@PathVariable Long id, @PathVariable EstadoPedidoEnum estadoPedido) {
    	
        Map<String, Object> response = new HashMap<>();
        
        try {
        	modificarEstadoPedidoManejador.ejecutar(id, estadoPedido);
		} catch (RuntimeException e) {
			response.put(MENSAJE, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put(MENSAJE, MensajesGeneralesEnum.PEDIDO_CREADO_EXITOSAMENTE.getMensaje());
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
}
