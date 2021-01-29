package com.pedidospizza.adnceiba.adicion.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ActualizarAdicionServicio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ConsultarAdicionServicio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.CrearAdicionServicio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.EliminarAdicionServicio;

@Configuration
public class AdicionServicioBean {
	@Bean
    public CrearAdicionServicio crearAdicionServicio(AdicionRepositorio adicionRepositorio) {
        return new CrearAdicionServicio(adicionRepositorio);
    }

    @Bean
    public ConsultarAdicionServicio consultarAdicionServicio(AdicionDao adicionDao) {
        return new ConsultarAdicionServicio(adicionDao);
    }
    
    @Bean
    public ActualizarAdicionServicio actualizarAdicionServicio(AdicionRepositorio adicionRepositorio) {
        return new ActualizarAdicionServicio(adicionRepositorio);
    }
    
    @Bean
    public EliminarAdicionServicio eliminarAdicionServicio(AdicionRepositorio adicionRepositorio) {
        return new EliminarAdicionServicio(adicionRepositorio);
    }
}
