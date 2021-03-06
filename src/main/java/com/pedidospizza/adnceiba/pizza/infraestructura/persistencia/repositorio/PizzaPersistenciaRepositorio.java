package com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pedidospizza.adnceiba.pizza.dominio.modelo.Pizza;
import com.pedidospizza.adnceiba.pizza.dominio.modelo.PizzaDto;
import com.pedidospizza.adnceiba.pizza.dominio.puerto.PizzaRepositorio;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.PizzaTranslader;
import com.pedidospizza.adnceiba.pizza.infraestructura.persistencia.entidad.PizzaEntidad;

@Repository
public class PizzaPersistenciaRepositorio implements PizzaRepositorio {
	
	private final EntityManager entityManager;

    public PizzaPersistenciaRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	@Override
	public Pizza crear(Pizza pizza) {
		PizzaEntidad pizzaEntidad = PizzaTranslader.parsePizzaToEntidad(pizza);
        entityManager.persist(pizzaEntidad);
        entityManager.flush();
        return new Pizza(
        		pizzaEntidad.getId(),
        		pizzaEntidad.getNombre(),
        		pizzaEntidad.getTipo(),
        		pizzaEntidad.getValor()
        );
	}

	@Override
	public Pizza actualizar(Pizza pizza) {
		
		PizzaEntidad pizzaEntidad = entityManager.find(PizzaEntidad.class, pizza.getId());
		
		pizzaEntidad.setNombre(pizza.getNombre());
		pizzaEntidad.setTipo(pizza.getTipo());
		pizzaEntidad.setValor(pizza.getValor());
		
		entityManager.merge(pizzaEntidad);
		
        entityManager.flush();
        
        return new Pizza(
        		pizzaEntidad.getId(),
        		pizzaEntidad.getNombre(),
        		pizzaEntidad.getTipo(),
        		pizzaEntidad.getValor()
        );
	}
	
	@Override
	public PizzaDto bucarPorId(Long id) {
		PizzaEntidad pizzaEntidadEncontrada = entityManager.find(PizzaEntidad.class, id);
		
		return PizzaTranslader.parsePizzaToDto(pizzaEntidadEncontrada);
	}
	
	@Override
	public PizzaEntidad bucarEntidad(Long id) {
		return entityManager.find(PizzaEntidad.class, id);
	}

	@Override
	public void eliminar(PizzaEntidad pizzaEntidad) {
		entityManager.remove(pizzaEntidad);
	}
	
	
}
