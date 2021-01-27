package com.pedidospizza.adnceiba.adicion.aplicacion.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ConsultarAdicionServicio;

@Component
public class ConsultarAdicionManejador {

	private final ConsultarAdicionServicio consultarAdicionServicio;

    public ConsultarAdicionManejador(ConsultarAdicionServicio consultarAdicionServicio) {
        this.consultarAdicionServicio = consultarAdicionServicio;
    }

    public List<AdicionDto> obtenerTodasAdiciones() {
        return consultarAdicionServicio.getAllAdiciones();
    }
	
	
	
}
