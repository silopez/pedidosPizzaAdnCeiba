package com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.adicion.dominio.modelo.Adicion;
import com.pedidospizza.adnceiba.adicion.dominio.puerto.AdicionRepositorio;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.AdicionTranslader;
import com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.entidad.AdicionEntidad;

@Repository
public class AdicionPersistenciaRepositorio implements AdicionRepositorio {

	private final EntityManager entityManager;

    public AdicionPersistenciaRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	@Override
	public Adicion crear(Adicion adicion) {
		AdicionEntidad adicionEntidad = AdicionTranslader.parseAdicionToEntidad(adicion);
        entityManager.persist(adicionEntidad);
        entityManager.flush();
        return new Adicion(
        		adicionEntidad.getId(),
        		adicionEntidad.getNombre(),
        		adicionEntidad.getDescripcion(),
        		adicionEntidad.getValor()
        );
	}

	@Override
	public Adicion actualizar(Adicion adicion) {
		AdicionEntidad adicionEntidad = AdicionTranslader.parseAdicionToEntidad(adicion);
		entityManager.persist(adicionEntidad);
        entityManager.flush();
		
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
	}
	
	
}
