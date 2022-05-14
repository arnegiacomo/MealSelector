package dev.arnemunthekaas.mealview;

import javax.servlet.http.HttpServletRequest;

import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.DB.entity.Mealrelations;

public class MealView {

	private String name;
	private String imageurl;
	private String description;
	private String type;
	private String cuisine;
	private String siteurl;
	private Integer preptime;
	private int ID;
	
	public MealView() {
		this.name = "No meal found. Please try again with other criteria!";
		this.imageurl = "https://www.apa.org/images/sad-title-image_tcm7-179953.jpg";
	}
	
	public MealView(HttpServletRequest request) {
		this(MealrelationsDAO.mealrelationsDAO.find(Integer.parseInt(request.getParameter("ID"))));	
	}

	public MealView(Mealrelations mealrelations) {
			this();
		if (mealrelations != null) {
			this.name = mealrelations.getMeal().getName();
			this.imageurl = mealrelations.getMeal().getImageurl();
			this.description = mealrelations.getMeal().getDescription();
			this.type = mealrelations.getType().getName();
			this.cuisine = mealrelations.getCuisine().getName();
			this.siteurl = mealrelations.getMeal().getSiteurl();
			this.preptime = mealrelations.getMeal().getPreptime();
			this.ID = mealrelations.getMeal().getID();
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

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "MealView [name=" + name + ", imageurl=" + imageurl + ", description=" + description + ", type=" + type
				+ ", cuisine=" + cuisine + ", siteurl=" + siteurl + ", preptime=" + preptime + ", ID=" + ID + "]";
	}

	

}
