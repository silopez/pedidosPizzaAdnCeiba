package com.pedidospizza.adnceiba.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.domain.entity.Pizza;

@Repository
public interface IPizzaRepository extends CrudRepository<Pizza, Long> {

}
