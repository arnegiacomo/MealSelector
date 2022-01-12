package dev.arnemunthekaas.DB.input;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.arnemunthekaas.DB.Meal;
import dev.arnemunthekaas.DB.MealDAO;

public class InputHandler {

	private MealDAO mealDAO;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private InputForm iForm;
	
	public InputHandler(MealDAO mealDAO, HttpServletRequest req, HttpServletResponse resp) {
		this.mealDAO = mealDAO;
		this.req = req;
		this.resp = resp;
	}
	
	public void start() {
		this.iForm = new InputForm(req);
		
		if(!MealValidator.validate(iForm)) {
			// Handle server side errors. Unimplemented, only simple back end validation 
		}
		
		Meal meal = new Meal();
		meal.setName(iForm.getName());
		meal.setType(iForm.getType());
		meal.setDescription(iForm.getDescription());
		meal.setPreptime(iForm.getPreptime());
		meal.setSiteurl(iForm.getSiteurl());
		meal.setImageurl(iForm.getImageurl());
		
		mealDAO.addMeal(meal);
		
		if(mealDAO.find(meal.getID()) != null)
		req.setAttribute("confirmedmeal", meal.toString());
	}
	
	
}
