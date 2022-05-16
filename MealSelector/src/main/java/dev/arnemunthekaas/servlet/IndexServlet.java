package dev.arnemunthekaas.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.arnemunthekaas.DB.DAO.CuisineDAO;
import dev.arnemunthekaas.DB.DAO.MealDAO;
import dev.arnemunthekaas.DB.DAO.MealrelationsDAO;
import dev.arnemunthekaas.DB.DAO.TypeDAO;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CuisineDAO cuisineDAO;
	@EJB
	private MealDAO mealDAO;
	@EJB
	private TypeDAO typeDAO;
	@EJB
	private MealrelationsDAO mealrelationsDAO;
	
	@Override
	public void init() throws ServletException {
		CuisineDAO.cuisineDAO = cuisineDAO;
		MealDAO.mealDAO = mealDAO;
		TypeDAO.typeDAO = typeDAO;
		MealrelationsDAO.mealrelationsDAO = mealrelationsDAO;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) 
			session.invalidate();
		
		request.setAttribute("cuisines", mealrelationsDAO.getAllUniqueCuisineNamesUsed());
		request.setAttribute("types", typeDAO.getAll());
		 request.getRequestDispatcher("WEB-INF/index.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
