package com.pedidospizza.adnceiba.pedido.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.PedidoComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.manejador.ConsultarPedidoManejador;
import com.pedidospizza.adnceiba.pedido.aplicacion.manejador.CrearPedidoManejador;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {
	
	private final CrearPedidoManejador crearPedidoManejador;
    private final ConsultarPedidoManejador consultarPedidoManejador;

    public PedidoControlador(CrearPedidoManejador crearPedidoManejador, ConsultarPedidoManejador consultarPedidoManejador) {
        this.crearPedidoManejador = crearPedidoManejador;
        this.consultarPedidoManejador = consultarPedidoManejador;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crearPedido(@RequestBody PedidoComando pedidoComando) {
        return crearPedidoManejador.ejecutar(pedidoComando);
    }

    @GetMapping
    public List<PedidoDto> obtenerPedido(){
        return consultarPedidoManejador.obtenerTodosPedidos();
    }
    
}
