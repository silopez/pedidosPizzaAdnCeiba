package com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.AdicionDto;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionDao;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.AdicionTranslader;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.entidad.AdicionEntidad;

@Repository
public class AdicionPersistenciaDao implements AdicionDao{

	private final EntityManager entityManager;
    private static final String ADICIONES = "Adicion.obtenerTodas";

    public AdicionPersistenciaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AdicionDto> getAdiciones() {
        List<AdicionDto> adicionDtos = new ArrayList<>();
        Query query = entityManager.createNamedQuery(ADICIONES);
        List adicionesEntidad = query.getResultList();
        for (Object adicionEntidad : adicionesEntidad) {
        	adicionDtos.add(AdicionTranslader.parseAdicionToDto((AdicionEntidad) adicionEntidad));
        }
        return adicionDtos;
    }
	
}
