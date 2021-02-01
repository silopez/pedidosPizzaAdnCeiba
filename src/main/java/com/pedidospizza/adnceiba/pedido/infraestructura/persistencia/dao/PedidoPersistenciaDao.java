package com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoDao;
import com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.PedidoTranslader;
import com.pedidospizza.adnceiba.pedido.infraestructura.persistencia.entidad.PedidoEntidad;

@Repository
public class PedidoPersistenciaDao implements PedidoDao {

	private final EntityManager entityManager;
    private static final String PEDIDOS = "Pedido.obtenerTodos";
    private static final String PEDIDO_ID = "Pedido.obtenerPorId";

    public PedidoPersistenciaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PedidoDto> getPedidos() {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        Query query = entityManager.createNamedQuery(PEDIDOS);
        List pedidosEntidad = query.getResultList();
        for (Object pedidoEntidad : pedidosEntidad) {
        	pedidoDtos.add(PedidoTranslader.parsePedidoToDto((PedidoEntidad) pedidoEntidad));
        }
        return pedidoDtos;
    }

	@Override
	public PedidoDto getPedidoPorId(Long id) {
		 Query query = entityManager.createNamedQuery(PEDIDO_ID);
		 PedidoEntidad pedidoEntidad = (PedidoEntidad) query.getSingleResult();
		 return PedidoTranslader.parsePedidoToDto(pedidoEntidad); 
	}
}
