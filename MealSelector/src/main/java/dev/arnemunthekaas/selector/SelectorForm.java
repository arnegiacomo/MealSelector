package dev.arnemunthekaas.selector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SelectorForm {

	private Long systime;
	private String type;
	private Integer preptime;
	private String cuisine;

	public SelectorForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		this.systime = System.currentTimeMillis();
		this.type = request.getParameter("type");
		String preptimeinput = request.getParameter("preptime");
		if (preptimeinput != null) {
			this.preptime = Integer.parseInt(preptimeinput);
		}
		this.cuisine = request.getParameter("cuisine");
		session.setAttribute("form", this);
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

	public void setPreptime(int preptime) {
		this.preptime = preptime;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setPreptime(Integer preptime) {
		this.preptime = preptime;
	}

	public Long getSystime() {
		return systime;
	}

	public void setSystime(Long systime) {
		this.systime = systime;
	}
	
	

	

}
