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

	// Random meal with specified search criteria
	public static MealView roulette(MealDAO mealDAO, HttpServletRequest req, MealrelationsDAO mealrelationsDAO) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute("form") == null)
			return roulette(mealDAO, new SelectorForm(req), mealrelationsDAO);

		MealView roulette = roulette(mealDAO, (SelectorForm) session.getAttribute("form"), mealrelationsDAO);
		MealView currentmeal = (MealView) session.getAttribute("currentmeal");
		if (currentmeal != null) {
			while (currentmeal.getID() == roulette.getID() && allThatMatch(mealDAO, req, mealrelationsDAO).size() > 1) {
				roulette = roulette(mealDAO, (SelectorForm) session.getAttribute("form"), mealrelationsDAO);
			}
		}
		session.setAttribute("currentmeal", roulette);
		return roulette;
	}

	public static List<MealView> allThatMatch(MealDAO mealDAO, HttpServletRequest req,
			MealrelationsDAO mealrelationsDAO) {
		HttpSession session = req.getSession(false);
		if (session.getAttribute("form") == null)
			return allThatMatch(mealDAO, new SelectorForm(req), mealrelationsDAO);
		return allThatMatch(mealDAO, (SelectorForm) session.getAttribute("form"), mealrelationsDAO);
	}

	private static List<MealView> allThatMatch(MealDAO mealDAO, SelectorForm selectorForm,
			MealrelationsDAO mealrelationsDAO) {
		List<Meal> meals = filterMeals(mealDAO, selectorForm, mealrelationsDAO);

		List<MealView> mealviews = new ArrayList<MealView>();
		
		for (Meal m : meals) {
			mealviews.add(new MealView(m, mealrelationsDAO.find(m)));
		}
		
		return mealviews;
	}

	private static MealView roulette(MealDAO mealDAO, SelectorForm selectorForm, MealrelationsDAO mealrelationsDAO) {
		return roulette(filterMeals(mealDAO, selectorForm, mealrelationsDAO), mealrelationsDAO);
	}

	private static MealView roulette(List<Meal> meals, MealrelationsDAO mealrelationsDAO) {
		MealView meal = new MealView(null, null);
		if (meals.size() > 0) {
			int min = 0;
			int max = meals.size() - 1;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			try {
				meal = new MealView(meals.get(random_int), mealrelationsDAO.find(meals.get(random_int)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return meal;
	}

	private static List<Meal> filterMeals(MealDAO mealDAO, SelectorForm selectorForm,
			MealrelationsDAO mealrelationsDAO) {
		List<Meal> meals = mealDAO.getAll();
		List<Mealrelations> mealrelations = mealrelationsDAO.getAll();

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

		return meals;

	}

}
