package no.arnemunthekaas.DB.input;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.StringEscapeUtils;

public class InputForm {

	
	private String name;
	private String description;
	private String typeSTR;
	private String cuisineSTR;
	private Integer preptime;
	private String siteurl;
	private String imageurl;

	public InputForm(HttpServletRequest request) {
		this.name = StringEscapeUtils.escapeHtml4((request.getParameter("name")));
		this.typeSTR = StringEscapeUtils.escapeHtml4(request.getParameter("type"));
		this.cuisineSTR = StringEscapeUtils.escapeHtml4(request.getParameter("cuisine"));
		String preptimeinput = request.getParameter("preptime");
		this.description = StringEscapeUtils.escapeHtml4(request.getParameter("description"));
		this.preptime = Integer.parseInt(preptimeinput);
		this.siteurl = StringEscapeUtils.escapeHtml4(request.getParameter("siteurl"));
		this.imageurl = StringEscapeUtils.escapeHtml4(request.getParameter("imageurl"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPreptime() {
		return preptime;
	}

	public void setPreptime(Integer preptime) {
		this.preptime = preptime;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getTypeSTR() {
		return typeSTR;
	}

	public void setTypeSTR(String typeSTR) {
		this.typeSTR = typeSTR;
	}

	public String getCuisineSTR() {
		return cuisineSTR;
	}

	public void setCuisineSTR(String cuisineSTR) {
		this.cuisineSTR = cuisineSTR;
	}

	@Override
	public String toString() {
		return "InputForm [name=" + name + ", description=" + description + ", typeSTR=" + typeSTR + ", cuisineSTR="
				+ cuisineSTR + ", preptime=" + preptime + ", siteurl=" + siteurl + ", imageurl=" + imageurl + "]";
	}


	
	
}
