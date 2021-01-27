package com.pedidospizza.adnceiba.adicion.dominio.servicio;

import java.util.List;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;

public class ConsultarAdicionServicio {

	private final AdicionDao adicionDao;

    public ConsultarAdicionServicio(AdicionDao adicionDao) {
        this.adicionDao = adicionDao;
    }

    public List<AdicionDto> getAllAdiciones() {
        return adicionDao.getAdiciones();
    }
	
}
