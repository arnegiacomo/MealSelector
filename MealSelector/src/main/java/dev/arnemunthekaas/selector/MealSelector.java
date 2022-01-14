package dev.arnemunthekaas.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dev.arnemunthekaas.DB.Meal;
import dev.arnemunthekaas.DB.MealDAO;
import dev.arnemunthekaas.mealview.MealView;

public class MealSelector {

	// Random meal with specified search criteria
	public static MealView roulette(MealDAO mealDAO, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute("form") == null)
			return roulette(mealDAO, new SelectorForm(req));
		
		MealView roulette = roulette(mealDAO, (SelectorForm) session.getAttribute("form"));
		MealView currentmeal = (MealView) session.getAttribute("currentmeal");
		if (currentmeal != null) {
			while(currentmeal.getID() == roulette.getID() && allThatMatch(mealDAO, req).size() > 1) {
				roulette = roulette(mealDAO, (SelectorForm) session.getAttribute("form"));
			}
		}
		session.setAttribute("currentmeal", roulette);
		return roulette;
	}
	
	public static List<MealView> allThatMatch(MealDAO mealDAO, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute("form") == null)
			return allThatMatch(mealDAO,  new SelectorForm(req));
		return allThatMatch(mealDAO, (SelectorForm) session.getAttribute("form"));
	}
	
	private static List<MealView> allThatMatch(MealDAO mealDAO, SelectorForm selectorForm) {
		List<Meal> meals = filterMeals(mealDAO, selectorForm);
		List<MealView> mealviews = new ArrayList<MealView>();
		for(Meal m : meals) {
			mealviews.add(new MealView(m));		}
		return mealviews;
	}
	

	private static MealView roulette(MealDAO mealDAO, SelectorForm selectorForm) {
		return roulette(filterMeals(mealDAO, selectorForm));
	}

	private static MealView roulette(List<Meal> meals) {
		MealView meal = new MealView(null);
		if (meals.size() > 0) {
			int min = 0;
			int max = meals.size() - 1;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			try {
				meal = new MealView(meals.get(random_int));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return meal;
	}
	
	private static List<Meal> filterMeals(MealDAO mealDAO, SelectorForm selectorForm) {
		List<Meal> meals = mealDAO.getAll();

		// filter by type
		if (selectorForm.getType() != null)
			meals = meals.stream().filter(m -> m.getType().equals(selectorForm.getType())).collect(Collectors.toList());

		// filter by time
		if (selectorForm.getPreptime() != null)
			meals = meals.stream().filter(m -> m.getPreptime() <= selectorForm.getPreptime())
					.collect(Collectors.toList());
		
		return meals;
		
	}
	
	

}
