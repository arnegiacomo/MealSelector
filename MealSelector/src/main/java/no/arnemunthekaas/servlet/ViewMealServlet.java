package no.arnemunthekaas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.arnemunthekaas.mealview.MealView;
import no.arnemunthekaas.selector.MealSelector;

@WebServlet(name = "ViewMealServlet", urlPatterns = "/viewmeal")
public class ViewMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meal", MealSelector.select());
		request.getRequestDispatcher("WEB-INF/viewmeal.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meal", new MealView(request));
		request.setAttribute("back", "database");
		request.setAttribute("goBack", true);
		request.getRequestDispatcher("WEB-INF/viewmeal.jsp")
 		.forward(request, response);
	}

}
