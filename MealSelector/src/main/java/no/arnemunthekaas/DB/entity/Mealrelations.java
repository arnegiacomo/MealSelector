package no.arnemunthekaas.DB.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "mealselector")
@IdClass(MealrelationsPK.class)
public class Mealrelations {

	@Id
    @ManyToOne
    @JoinColumn(name="Mealid")
    private Meal meal;
	
	@ManyToOne
    @JoinColumn(name="Type")
    private Type type;
	
	@ManyToOne
    @JoinColumn(name="Cuisine")
    private Cuisine cuisine;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() { 
		try {
			return "Mealrelations [meal=" + meal.toString() + ", type=" + type.toString() + ", cuisine=" + cuisine.toString() + "]";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "str";
	}

	

}
