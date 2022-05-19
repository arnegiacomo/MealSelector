package no.arnemunthekaas.DB.input;

import javax.servlet.http.HttpServletRequest;

import no.arnemunthekaas.DB.DAO.CuisineDAO;
import no.arnemunthekaas.DB.DAO.MealDAO;
import no.arnemunthekaas.DB.DAO.MealrelationsDAO;
import no.arnemunthekaas.DB.DAO.TypeDAO;
import no.arnemunthekaas.DB.entity.Meal;
import no.arnemunthekaas.DB.entity.Mealrelations;

public class InputHandler {

	private MealDAO mealDAO;
	private CuisineDAO cuisineDAO;
	private TypeDAO typeDAO;
	private MealrelationsDAO mealrelationsDAO;
	private HttpServletRequest req;
	private InputForm iForm;
	
	

	public InputHandler(HttpServletRequest req) {
		this.mealDAO = MealDAO.mealDAO;
		this.cuisineDAO = CuisineDAO.cuisineDAO;
		this.typeDAO = TypeDAO.typeDAO;
		this.mealrelationsDAO = MealrelationsDAO.mealrelationsDAO;
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
		req.setAttribute("ID", meal.getID());
	}
	
	
}
