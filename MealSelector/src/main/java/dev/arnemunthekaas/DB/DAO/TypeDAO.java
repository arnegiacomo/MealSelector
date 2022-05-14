package dev.arnemunthekaas.DB.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.arnemunthekaas.DB.entity.Type;

@Stateless
public class TypeDAO {
	
	public static TypeDAO typeDAO;
	
	@PersistenceContext(name = "mealDB")
	private EntityManager em;
	
	public List<Type> getAll() {
		List<Type> alltypes = em.createQuery("select m from Type m", Type.class).getResultList();
		return alltypes;
	}
	
	public Type find(String name) {
		try {
			return em.find(Type.class, name);
		} catch (Exception e) {
			return null;
		}	
	}

}
