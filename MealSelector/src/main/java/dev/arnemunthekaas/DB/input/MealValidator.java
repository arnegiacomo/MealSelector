package dev.arnemunthekaas.DB.input;


public class MealValidator {

	//TODO Simple validator to check for null values, only real validation comes from regex in inputmeal.js
	public static boolean validate(InputForm iForm) {
		return validName(iForm.getName()) && validDescription(iForm.getDescription()) && validType(iForm.getTypeSTR()) && validCuisine(iForm.getCuisineSTR()) && validPreptime(iForm.getPreptime()) && validSiteURL(iForm.getSiteurl()) && validImageURL(iForm.getImageurl());
	}
	
	private static boolean validCuisine(String cuisineSTR) {
		if (cuisineSTR == null) 
			return false;
		//TODO
		
		return true;
	}

	private static boolean validName(String name) {
		if (name == null) 
			return false;
		//TODO
		
		return true;
	}
	
	private static boolean validDescription(String description) {
		if(description == null)
			return false;
		//TODO
		
		return true;
	}
	
	private static boolean validType(String type) {
		if(type == null) 
			return false;
		//TODO
		
		return true;	
	}
	
	private static boolean validPreptime(Integer preptime) {
		if(preptime == null) 
			return false;
		//TODO
		return true;
		
	}
	
	private static boolean validSiteURL(String siteurl) {
		if(siteurl == null) 
			return false;
		//TODO
		return true;
		
	}
	
	private static boolean validImageURL(String imageurl) {
		if(imageurl == null)
			return false;
		//TODO
		return true;
		
	}
	

}
