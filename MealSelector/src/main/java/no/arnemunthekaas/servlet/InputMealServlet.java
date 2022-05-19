package no.arnemunthekaas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.arnemunthekaas.DB.DAO.CuisineDAO;
import no.arnemunthekaas.DB.DAO.TypeDAO;
import no.arnemunthekaas.DB.input.InputHandler;

@WebServlet(name = "InputMealServlet", urlPatterns = "/inputmeal")
public class InputMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cuisines", CuisineDAO.cuisineDAO.getAll());
		request.setAttribute("types", TypeDAO.typeDAO.getAll());
		request.getRequestDispatcher("WEB-INF/inputmeal.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputHandler iHandler = new InputHandler(request);
		iHandler.start();
		request.getRequestDispatcher("WEB-INF/inputconfirmation.jsp")
 		.forward(request, response);
	}

}
