package com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaDao;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.PizzaTranslader;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

@Repository
public class PizzaPersistenciaDao  implements PizzaDao{
	private final EntityManager entityManager;
    private static final String PIZZAS = "Pizza.obtenerTodas";

    public PizzaPersistenciaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PizzaDto> getPizzas() {
        List<PizzaDto> pizzaDtos = new ArrayList<>();
        Query query = entityManager.createNamedQuery(PIZZAS);
        List pizzasEntidad = query.getResultList();
        for (Object pizzaEntidad : pizzasEntidad) {
        	pizzaDtos.add(PizzaTranslader.parsePizzaToDto((PizzaEntidad) pizzaEntidad));
        }
        return pizzaDtos;
    }
}
