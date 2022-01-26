package dev.arnemunthekaas.DB.input;

import javax.servlet.http.HttpServletRequest;

import dev.arnemunthekaas.DB.DAO.CuisineDAO;
import dev.arnemunthekaas.DB.DAO.MealDAO;
import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.DB.DAO.TypeDAO;
import dev.arnemunthekaas.DB.entity.Meal;
import dev.arnemunthekaas.DB.entity.Mealrelations;

public class InputHandler {

	private MealDAO mealDAO;
	private CuisineDAO cuisineDAO;
	private TypeDAO typeDAO;
	private MealrelationsDAO mealrelationsDAO;
	private HttpServletRequest req;
	private InputForm iForm;
	
	

	public InputHandler(MealDAO mealDAO, CuisineDAO cuisineDAO, TypeDAO typeDAO, MealrelationsDAO mealrelationsDAO,
			HttpServletRequest req) {
		this.mealDAO = mealDAO;
		this.cuisineDAO = cuisineDAO;
		this.typeDAO = typeDAO;
		this.mealrelationsDAO = mealrelationsDAO;
		this.req = req;
	}



	public void start() {
		this.iForm = new InputForm(req);
		
		if(!MealValidator.validate(iForm)) {
			// Handle server side errors. Unimplemented, only simple front end validation 
		}
		
		Meal meal = new Meal();
		meal.setName(iForm.getName());
		meal.setDescription(iForm.getDescription());
		meal.setPreptime(iForm.getPreptime());
		meal.setSiteurl(iForm.getSiteurl());
		meal.setImageurl(iForm.getImageurl());
		
		Mealrelations mealrelations = new Mealrelations();
		mealrelations.setMeal(meal);
		mealrelations.setType(typeDAO.find(iForm.getTypeSTR()));
		mealrelations.setCuisine(cuisineDAO.find(iForm.getCuisineSTR()));
		
		mealDAO.addMeal(meal);
		mealrelationsDAO.addRelation(mealrelations);

		req.setAttribute("confirmedmeal", meal.toString() + "\n" + mealrelations.toString());
	}
	
	
}
