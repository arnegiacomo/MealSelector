package dev.arnemunthekaas.selector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SelectorForm {

	private String type;
	private Integer preptime;

	public SelectorForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		this.type = request.getParameter("type");
		String preptimeinput = request.getParameter("preptime");
		if (preptimeinput != null) {
			this.preptime = Integer.parseInt(preptimeinput);
		}
		
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

}
