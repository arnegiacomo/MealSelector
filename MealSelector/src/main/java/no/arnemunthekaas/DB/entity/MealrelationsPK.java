package no.arnemunthekaas.DB.entity;

import javax.persistence.Id;

@SuppressWarnings("unused")
public class MealrelationsPK {
	
	private int meal;   
    
    public MealrelationsPK() {}
    
    public MealrelationsPK(int mealID) {
        this.meal = mealID;
    }
}
