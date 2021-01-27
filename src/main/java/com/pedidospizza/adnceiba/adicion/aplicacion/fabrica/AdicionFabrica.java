package com.pedidospizza.adnceiba.adicion.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;

@Component
public class AdicionFabrica {
	
	public Adicion crearAdicion(AdicionComando adicionComando) {
        return new Adicion(adicionComando.getId(), adicionComando.getNombre(), adicionComando.getDescripcion(), adicionComando.getValor());
    }
	
	public Adicion actualizarAdicion(AdicionComando adicionComando) {
        return new Adicion(adicionComando.getId(), adicionComando.getNombre(), adicionComando.getDescripcion(), adicionComando.getValor());
    }
}