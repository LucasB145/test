package fr.eni.javaee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.bo.Ingredient;
import fr.eni.javaee.bo.Repas;
import fr.eni.javaee.dll.RepasManager;

/**
 * Servlet implementation class
 */
@WebServlet("/historique")
public class HistoriqueServlet extends HttpServlet {

	private RepasManager repasManager = new RepasManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Repas> repas = this.repasManager.getAll();

		if (request.getParameter("idRepas") != null) {
			int idRepas = Integer.valueOf(request.getParameter("idRepas"));
			List<Ingredient> ingredients = this.repasManager.getIngredients(idRepas);
			request.setAttribute("listeIngredients", ingredients);
			// System.out.println(ingredients);
		}

		request.setAttribute("listeRepas", repas);

		request.getRequestDispatcher("/WEB-INF/historique.jsp").forward(request, response);
	}

}
