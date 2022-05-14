package dev.arnemunthekaas.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.mealview.MealView;

public class MealSelector {
	
	// TODO: reimplement last meal attribute, so that the same meal doesnt pop up twice
	public static MealView select(HttpServletRequest req) {
		MealView meal = new MealView();

		HttpSession session = req.getSession(false);
		SelectorForm form = (SelectorForm) session.getAttribute("form");

		if (form != null) {
			meal = select(form);

		} else {
			meal = roulette();
		}

		return meal;
	}
	
	public static MealView select(SelectorForm form) {
		return roulette(form);
	}
	
	public static MealView select() {
		return roulette();
	}

	private static List<MealView> filter(List<MealView> views, SelectorForm selectorForm) {

		// filter by type
		String type = selectorForm.getType();
		if (type != null && type != "") {
			views = views.stream().filter(m -> m.getType().equals(type)).collect(Collectors.toList());
		}

		// filter by cuisine
		String cuisine = selectorForm.getCuisine();
		if (cuisine != null && cuisine != "") {
			views = views.stream().filter(m -> m.getCuisine().equals(cuisine)).collect(Collectors.toList());
		}

		// filter by time
		Integer preptime = selectorForm.getPreptime();
		if (preptime != null) {
			views = views.stream().filter(m -> m.getPreptime()<=preptime).collect(Collectors.toList());
		}

		return views;

	}
	
	public static List<MealView> getAllMealViews() {
		List<MealView> views = new ArrayList<MealView>();
		
		MealrelationsDAO.mealrelationsDAO.getAll().forEach(r -> views.add(new MealView(r)));
		
		return views;
	}
	
	private static MealView roulette() {
		return roulette(getAllMealViews());
	}
	
	private static MealView roulette(SelectorForm form) {
		return roulette(filter(getAllMealViews(), form));
	}
	
	private static MealView roulette(List<MealView> meals) {
		MealView meal = new MealView();
		if (meals.size() > 0) {
			int min = 0;
			int max = meals.size() - 1;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			meal = meals.get(random_int);
		}
		return meal;
	}

}
