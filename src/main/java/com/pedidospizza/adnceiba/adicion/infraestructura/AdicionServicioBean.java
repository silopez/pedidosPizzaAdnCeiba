package com.pedidospizza.adnceiba.adicion.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.ConsultarAdicionServicio;
import com.pedidospizza.adnceiba.adicion.dominio.servicio.CrearAdicionServicio;

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
}
