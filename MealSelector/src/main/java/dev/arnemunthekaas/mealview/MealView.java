package dev.arnemunthekaas.mealview;

import javax.servlet.http.HttpServletRequest;

import dev.arnemunthekaas.DB.Meal;
import dev.arnemunthekaas.DB.MealDAO;

public class MealView {

	private String name;
	private String imageurl;
	private String description;
	private String type;
	private String siteurl;
	private Integer preptime;
	private int ID;

	public MealView(Meal meal) {
		if (meal == null) {
			this.name = "No meal found. Please try again with other criteria!";
			this.imageurl = "https://www.apa.org/images/sad-title-image_tcm7-179953.jpg";
		} else {
			this.name = meal.getName();
			this.imageurl = meal.getImageurl();
			this.description = meal.getDescription();
			this.type = meal.getType();
			this.siteurl = meal.getSiteurl();
			this.preptime = meal.getPreptime();
			this.ID = meal.getID();
		}
	}

	public MealView(MealDAO mealDAO, HttpServletRequest request) {
		try {
			int ID = Integer.parseInt(request.getParameter("ID"));
			Meal meal = mealDAO.find(ID);
			this.name = meal.getName();
			this.imageurl = meal.getImageurl();
			this.description = meal.getDescription();
			this.type = meal.getType();
			this.siteurl = meal.getSiteurl();
			this.preptime = meal.getPreptime();
			this.ID = meal.getID();
		} catch (Exception e) {
			this.name = "No meal found. Please try again with other criteria!";
			this.imageurl = "https://www.apa.org/images/sad-title-image_tcm7-179953.jpg";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public Integer getPreptime() {
		return preptime;
	}

	public void setPreptime(Integer preptime) {
		this.preptime = preptime;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Mealview [name=" + name + ", imageurl=" + imageurl + ", description=" + description + ", type=" + type
				+ ", siteurl=" + siteurl + ", preptime=" + preptime + "]";
	}

}
