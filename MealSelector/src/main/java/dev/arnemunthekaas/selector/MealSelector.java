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

	public static MealView select(HttpServletRequest req) {
		try {
			HttpSession session = req.getSession(false);
			MealView lastmeal = (MealView) session.getAttribute("lastmeal");
			SelectorForm form = (SelectorForm) session.getAttribute("form");
			MealView meal = new MealView();
			
			if (form != null) {
				meal = select(form);
				
				while(lastmeal != null && lastmeal.getID() == meal.getID() && filter(getAllMealViews(), form).size() > 1) {
					meal = select(form);
				}
				
			} else {
				meal = roulette(req);
			}
			
			session.setAttribute("lastmeal", meal);
			return meal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static MealView select(SelectorForm form) {
		return roulette(form);
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
	
	public static List<MealView> getAllMealViews() {
		return getAllMealViews(MealrelationsDAO.mealrelationsDAO.getAll());
	}
	
	private static List<MealView> getAllMealViews(List<Mealrelations> relations) {
		List<MealView> views = new ArrayList<MealView>();
		
		relations.forEach(r -> views.add(new MealView(r)));
		
		return views;
	}
	
	public static List<MealView> getAllFilteredMealViews(HttpServletRequest req) {
		return filter(getAllMealViews(), req);
	}
	
	public static List<MealView> getAllFilteredMealViews(SelectorForm form) {
		return filter(getAllMealViews(), form);
	}
	
	private static MealView roulette(HttpServletRequest req) {
		return roulette((getAllFilteredMealViews(req)));
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
