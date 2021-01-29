package com.pedidospizza.adnceiba.pizza.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ActualizarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.ConsultarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.CrearPizzaManejador;
import com.pedidospizza.adnceiba.pizza.aplicacion.manejador.EliminarPizzaManejador;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;

@RestController
@RequestMapping("/pizzas")
public class PizzaControlador {

	private final CrearPizzaManejador crearPizzaManejador;
    private final ConsultarPizzaManejador consultarPizzaManejador;
    private final ActualizarPizzaManejador actualizarPizzaManejador;
    private final EliminarPizzaManejador eliminarPizzaManejador;

    public PizzaControlador(CrearPizzaManejador crearPizzaManejador, ConsultarPizzaManejador consultarPizzaManejador, ActualizarPizzaManejador actualizarPizzaManejador, EliminarPizzaManejador eliminarPizzaManejador) {
        this.crearPizzaManejador = crearPizzaManejador;
        this.consultarPizzaManejador = consultarPizzaManejador;
        this.actualizarPizzaManejador = actualizarPizzaManejador;
        this.eliminarPizzaManejador = eliminarPizzaManejador;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza crearPizza(@RequestBody PizzaComando pizzaComando) {
        return crearPizzaManejador.ejecutar(pizzaComando);
    }

    @GetMapping
    public List<PizzaDto> obtenerPizza(){
        return consultarPizzaManejador.obtenerTodasPizzas();
    }
    
    @PutMapping
    public Pizza  actualizarPizza(@RequestBody PizzaComando pizzaComando) {
    	return actualizarPizzaManejador.ejecutar(pizzaComando);
    }
    
    @DeleteMapping("/{id}")
    public void  eliminarPizza(@PathVariable Long id) {
    	 eliminarPizzaManejador.ejecutar(id);
    }
    
}
