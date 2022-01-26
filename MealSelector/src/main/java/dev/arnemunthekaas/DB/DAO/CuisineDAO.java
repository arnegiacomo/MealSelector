package dev.arnemunthekaas.DB.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.arnemunthekaas.DB.entity.Cuisine;

@Stateless
public class CuisineDAO {
	
	@PersistenceContext(name = "mealDB")
	private EntityManager em;
	
	public List<Cuisine> getAll() {
		List<Cuisine> allcuisines = em.createQuery("select m from Cuisine m", Cuisine.class).getResultList();
		return allcuisines;
	}
	
	public Cuisine find(String name) {
		try {
			return em.find(Cuisine.class, name);
		} catch (Exception e) {
			return null;
		}	
	}

}
