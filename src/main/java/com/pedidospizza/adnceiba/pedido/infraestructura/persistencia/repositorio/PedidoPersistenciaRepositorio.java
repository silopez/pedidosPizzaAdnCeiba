package com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.PedidoTranslader;
import com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.entidad.PedidoEntidad;

@Repository
public class PedidoPersistenciaRepositorio implements PedidoRepositorio {

	private final EntityManager entityManager;

    public PedidoPersistenciaRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	@Override
	public Pedido crear(Pedido pedido) {
		PedidoEntidad pedidoEntidad = PedidoTranslader.parsePedidoToEntidad(pedido);
        entityManager.persist(pedidoEntidad);
        entityManager.flush();
        return new Pedido(
        		pedidoEntidad.getId(),
        		pedidoEntidad.getNombre(),
        		pedidoEntidad.getDireccion(),
        		pedidoEntidad.getTotal(),
        		pedidoEntidad.getEstadoPedido()
        );
	}

	@Override
	public Pedido actualizar(Pedido pedido) {
		PedidoEntidad pedidoEntidad = PedidoTranslader.parsePedidoToEntidad(pedido);
		entityManager.persist(pedidoEntidad);
        entityManager.flush();
		
		return null;
	}

}
