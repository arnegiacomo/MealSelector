package dev.arnemunthekaas.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dev.arnemunthekaas.DB.DAO.MealDAO;
import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.DB.entity.Meal;
import dev.arnemunthekaas.DB.entity.Mealrelations;
import dev.arnemunthekaas.mealview.MealView;

public class MealSelector {

	public static MealView select(MealrelationsDAO mealrelationsDAO, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute("form") == null)
			return roulette(mealrelationsDAO);

		MealView meal = roulette(mealrelationsDAO, req);
		MealView lastmeal = (MealView) session.getAttribute("currentmeal");
		
		if (lastmeal != null) {
			while (lastmeal.getID() == meal.getID() && getAllFilteredMealViews(mealrelationsDAO, req).size() > 1) {
				roulette(mealrelationsDAO, req);
			}
		}
		
		session.setAttribute("currentmeal", meal);
		return meal;
	}

	private static List<MealView> filter(List<MealView> list, HttpServletRequest req) {
		SelectorForm form = (SelectorForm) req.getAttribute("form");
		return(filter(list, form));
	}


	private static List<MealView> filter(List<MealView> views, SelectorForm selectorForm) {

//		// filter by type
//		String type = selectorForm.getType();
//		if (type != null) {
//			mealrelations = mealrelations.stream().filter(m -> m.getType().getName().equals(type))
//					.collect(Collectors.toList());
//			meals = mealrelations.stream().map(m -> m.getMeal()).collect(Collectors.toList());
//		}
//
//		// filter by cuisine
//		String cuisine = selectorForm.getCuisine();
//		if (cuisine != null) {
//			mealrelations = mealrelations.stream().filter(m -> m.getCuisine().getName().equals(cuisine))
//					.collect(Collectors.toList());
//			meals = mealrelations.stream().map(m -> m.getMeal()).collect(Collectors.toList());
//		}
//
//		// filter by time
//		Integer preptime = selectorForm.getPreptime();
//		if (preptime != null) {
//			meals = meals.stream().filter(m -> m.getPreptime() <= preptime).collect(Collectors.toList());
//		}
//
//		System.out.println(preptime);
//		System.out.println(cuisine);
//		System.out.println(type);
//		

		return null;

	}
	
	public static List<MealView> getAllMealViews(MealrelationsDAO relations) {
		return getAllMealViews(relations.getAll());
	}
	
	public static List<MealView> getAllFilteredMealViews(MealrelationsDAO relations, HttpServletRequest req) {
		return filter(getAllMealViews(relations), req);
	}

	private static List<MealView> getAllMealViews(List<Mealrelations> relations) {
		List<MealView> views = new ArrayList<MealView>();
		
		relations.forEach(r -> views.add(new MealView(r)));
		
		return views;
	}
	
	private static MealView roulette(MealrelationsDAO mealrelationsDAO) {
		return roulette(getAllMealViews(mealrelationsDAO));
	}
	
	private static MealView roulette(MealrelationsDAO mealrelationsDAO, HttpServletRequest req) {
		return roulette((getAllFilteredMealViews(mealrelationsDAO, req)));
	}

	
	private static MealView roulette(List<MealView> meals) {
		MealView meal = new MealView(null);
		if (meals.size() > 0) {
			int min = 0;
			int max = meals.size() - 1;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			meal = meals.get(random_int);
		}
		return meal;
	}

}
