package dev.arnemunthekaas.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.selector.MealSelector;

@WebServlet(name = "DatabaseServlet", urlPatterns = "/database")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private MealrelationsDAO mealrelationsDAO;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meals", MealSelector.getAllMealViews(mealrelationsDAO));
		request.getRequestDispatcher("WEB-INF/database.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
