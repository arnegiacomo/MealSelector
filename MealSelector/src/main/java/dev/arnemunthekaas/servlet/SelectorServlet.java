package dev.arnemunthekaas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.arnemunthekaas.selector.MealSelector;
import dev.arnemunthekaas.selector.SelectorForm;

@WebServlet(name = "SelectorServlet", urlPatterns = "/selector")
public class SelectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meal", MealSelector.select(request));
		request.getRequestDispatcher("WEB-INF/selector.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectorForm form = new SelectorForm(request);
		request.setAttribute("meal", MealSelector.select(form));
		request.getRequestDispatcher("WEB-INF/selector.jsp")
 		.forward(request, response);
	}

}
