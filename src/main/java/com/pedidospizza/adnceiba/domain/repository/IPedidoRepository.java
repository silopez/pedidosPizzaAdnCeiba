package com.pedidospizza.adnceiba.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.domain.entity.Pedido;

@Repository
public interface IPedidoRepository extends CrudRepository<Pedido, Long>{

}
