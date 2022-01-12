package dev.arnemunthekaas.DB.input;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.StringEscapeUtils;

public class InputForm {

	
	private String name;
	private String description;
	private String type;
	private Integer preptime;
	private String siteurl;
	private String imageurl;

	public InputForm(HttpServletRequest request) {
		this.name = StringEscapeUtils.escapeHtml4((request.getParameter("name")));
		this.type = StringEscapeUtils.escapeHtml4(request.getParameter("type"));
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "InputForm [name=" + name + ", description=" + description + ", type=" + type + ", preptime=" + preptime
				+ ", siteurl=" + siteurl + ", imageurl=" + imageurl + "]";
	}
	
	
	
}
