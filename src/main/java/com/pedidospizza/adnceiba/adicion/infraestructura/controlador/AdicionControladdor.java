package com.pedidospizza.adnceiba.adicion.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.ConsultarAdicionManejador;
import com.pedidospizza.adnceiba.adicion.aplicacion.manejador.CrearAdicionManejador;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;

@RestController
@RequestMapping("/adicion")
public class AdicionControladdor {
	
	private final CrearAdicionManejador crearAdicionManejador;
    private final ConsultarAdicionManejador consultarAdicionManejador;

    public AdicionControladdor(CrearAdicionManejador crearAdicionManejador, ConsultarAdicionManejador consultarAdicionManejador) {
        this.crearAdicionManejador = crearAdicionManejador;
        this.consultarAdicionManejador = consultarAdicionManejador;
    }

    @PostMapping
    public Adicion crearAdicion(@RequestBody AdicionComando adicionComando) {
        return crearAdicionManejador.ejecutar(adicionComando);
    }

    @GetMapping
    public List<AdicionDto> obtenerAdicion(){
        return consultarAdicionManejador.obtenerTodasAdiciones();
    }

}
