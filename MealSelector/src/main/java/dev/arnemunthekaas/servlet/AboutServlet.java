package dev.arnemunthekaas.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.arnemunthekaas.DB.MealDAO;
import dev.arnemunthekaas.mealview.MealView;

@WebServlet(name = "AboutServlet", urlPatterns = "/about")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	MealDAO mealDAO;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/about.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meal", new MealView(mealDAO, request));
		request.getRequestDispatcher("WEB-INF/viewmeal.jsp")
 		.forward(request, response);
		// DETTE ER EN KOMMENTAR!
	}

}
