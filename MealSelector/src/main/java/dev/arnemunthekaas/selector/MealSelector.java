package dev.arnemunthekaas.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.DB.entity.Mealrelations;
import dev.arnemunthekaas.mealview.MealView;

public class MealSelector {

	public static MealView select(MealrelationsDAO mealrelationsDAO, HttpServletRequest req) {
		try {
			HttpSession session = req.getSession(false);
			MealView lastmeal = (MealView) session.getAttribute("lastmeal");
			SelectorForm form = (SelectorForm) session.getAttribute("form");
			MealView meal = new MealView(null);
			
			if (form != null) {
				meal = select(mealrelationsDAO, form);
				
				while(lastmeal != null && lastmeal.getID() == meal.getID() && filter(getAllMealViews(mealrelationsDAO), form).size() > 1) {
					meal = select(mealrelationsDAO, form);
				}
				
			} else {
				meal = roulette(mealrelationsDAO, req);
			}
			
			session.setAttribute("lastmeal", meal);
			return meal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static MealView select(MealrelationsDAO mealrelationsDAO, SelectorForm form) {
		return roulette(mealrelationsDAO, form);
	}

	private static List<MealView> filter(List<MealView> list, HttpServletRequest req) {
		SelectorForm form = new SelectorForm(req);
		return(filter(list, form));
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

		System.out.println(preptime);
		System.out.println(cuisine);
		System.out.println(type);	
		
		views.forEach(x -> System.out.println(x.toString()));

		return views;

	}
	
	public static List<MealView> getAllMealViews(MealrelationsDAO relations) {
		return getAllMealViews(relations.getAll());
	}
	
	public static List<MealView> getAllFilteredMealViews(MealrelationsDAO relations, HttpServletRequest req) {
		return filter(getAllMealViews(relations), req);
	}
	
	public static List<MealView> getAllFilteredMealViews(MealrelationsDAO relations, SelectorForm form) {
		return filter(getAllMealViews(relations), form);
	}

	private static List<MealView> getAllMealViews(List<Mealrelations> relations) {
		List<MealView> views = new ArrayList<MealView>();
		
		relations.forEach(r -> views.add(new MealView(r)));
		
		return views;
	}
	
	private static MealView roulette(MealrelationsDAO mealrelationsDAO, HttpServletRequest req) {
		return roulette((getAllFilteredMealViews(mealrelationsDAO, req)));
	}
	
	private static MealView roulette(MealrelationsDAO mealrelationsDAO, SelectorForm form) {
		return roulette(filter(getAllMealViews(mealrelationsDAO), form));
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
