package dev.arnemunthekaas.DB.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.arnemunthekaas.DB.entity.Meal;
import dev.arnemunthekaas.DB.entity.Mealrelations;

@Stateless
public class MealrelationsDAO {

	@PersistenceContext(name = "mealDB")
	private EntityManager em;

	public List<Mealrelations> getAll() {
		List<Mealrelations> allrelations = em.createQuery("select m from Mealrelations m", Mealrelations.class).getResultList();
		return allrelations;
	}
	
	public void addRelation(Mealrelations mealrelations) {
		em.persist(mealrelations);
	}
	
	public Mealrelations find(Meal meal) {
		for(Mealrelations x : getAll()) {
			if(x.getMeal().getID() == meal.getID())
				return x;
		}
		return null;
	}
}
