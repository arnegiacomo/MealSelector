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
			if (preptimeinput.equals("1"))
				preptime = 15;
			if (preptimeinput.equals("2"))
				preptime = 30;
			if (preptimeinput.equals("3"))
				preptime = 45;
			if (preptimeinput.equals("4"))
				preptime = 60;
			if (preptimeinput.equals("5"))
				preptime = 90;
			if (preptimeinput.equals("6"))
				preptime = Integer.MAX_VALUE;

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
