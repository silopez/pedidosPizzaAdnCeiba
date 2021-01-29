package com.pedidospizza.adnceiba.adicion.infraestructura.controlador;

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

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.ActualizarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.ConsultarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.CrearAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.EliminarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;

@RestController
@RequestMapping("/adiciones")
public class AdicionControlador {
	
	private final CrearAdicionManejador crearAdicionManejador;
    private final ConsultarAdicionManejador consultarAdicionManejador;
    private final ActualizarAdicionManejador actualizarAdicionManejador;
    private final EliminarAdicionManejador eliminarAdicionManejador;

    public AdicionControlador(CrearAdicionManejador crearAdicionManejador, ConsultarAdicionManejador consultarAdicionManejador, ActualizarAdicionManejador actualizarAdicionManejador, EliminarAdicionManejador eliminarAdicionManejador) {
        this.crearAdicionManejador = crearAdicionManejador;
        this.consultarAdicionManejador = consultarAdicionManejador;
        this.actualizarAdicionManejador = actualizarAdicionManejador;
        this.eliminarAdicionManejador = eliminarAdicionManejador;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Adicion crearAdicion(@RequestBody AdicionComando adicionComando) {
        return crearAdicionManejador.ejecutar(adicionComando);
    }

    @GetMapping
    public List<AdicionDto> obtenerAdicion(){
        return consultarAdicionManejador.obtenerTodasAdiciones();
    }
    
    @PutMapping
    public Adicion  actualizarAdicion(@RequestBody AdicionComando adicionComando) {
    	return actualizarAdicionManejador.ejecutar(adicionComando);
    }
    
    @DeleteMapping("/{id}")
    public void  eliminarAdicion(@PathVariable Long id) {
    	 eliminarAdicionManejador.ejecutar(id);
    }

}
