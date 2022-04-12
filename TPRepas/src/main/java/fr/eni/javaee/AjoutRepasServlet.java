package fr.eni.javaee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.bo.Ingredient;
import fr.eni.javaee.bo.Repas;
import fr.eni.javaee.dll.BusinessException;
import fr.eni.javaee.dll.RepasManager;

/**
 * Servlet implementation class AjoutRepasServlet
 */
@WebServlet("/ajoutRepas")
public class AjoutRepasServlet extends HttpServlet {

	private RepasManager repasManager = new RepasManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/ajoutRepas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocalDate date;
		LocalTime heure;
		String texte;
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		String[] tableauIngredients;

		Repas repas = new Repas();

		try {
			date = LocalDate.parse(request.getParameter("date"));
			// System.out.println(date);
			heure = LocalTime.parse(request.getParameter("heure"));
			// System.out.println(heure);
			texte = request.getParameter("description");
			// System.out.println(texte);

			tableauIngredients = texte.split(",");
			for (String ingredient : tableauIngredients) {
				Ingredient i = new Ingredient(ingredient.trim());
				ingredients.add(i);
			}
			repas = new Repas(date, heure, ingredients);

			try {
				repasManager.ajouter(repas);
				response.sendRedirect("./historique");
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajoutRepas.jsp");
//				rd.forward(request, response);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("messageErreur", e.getMessage());
				this.doGet(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(repas);

		// System.out.println("test");

	}

}
