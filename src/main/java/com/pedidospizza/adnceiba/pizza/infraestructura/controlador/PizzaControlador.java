package com.pedidospizza.adnceiba.pizza.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ActualizarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ConsultarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.CrearPizzaManejador;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;

@RestController
@RequestMapping("/pizza")
public class PizzaControlador {

	private final CrearPizzaManejador crearPizzaManejador;
    private final ConsultarPizzaManejador consultarPizzaManejador;
    private final ActualizarPizzaManejador actualizarPizzaManejador;

    public PizzaControlador(CrearPizzaManejador crearPizzaManejador, ConsultarPizzaManejador consultarPizzaManejador, ActualizarPizzaManejador actualizarPizzaManejador) {
        this.crearPizzaManejador = crearPizzaManejador;
        this.consultarPizzaManejador = consultarPizzaManejador;
        this.actualizarPizzaManejador = actualizarPizzaManejador;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza crearPizza(@RequestBody PizzaComando pizzaComando) {
        return crearPizzaManejador.ejecutar(pizzaComando);
    }

    @GetMapping("/listarTodas")
    public List<PizzaDto> obtenerPizza(){
        return consultarPizzaManejador.obtenerTodasPizzas();
    }
    
    @PostMapping("/actualizar")
    public Pizza  actualizarPizza(@RequestBody PizzaComando pizzaComando) {
    	return actualizarPizzaManejador.ejecutar(pizzaComando);
    }
}
