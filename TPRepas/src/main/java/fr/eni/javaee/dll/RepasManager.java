package fr.eni.javaee.dll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.bo.Ingredient;
import fr.eni.javaee.bo.Repas;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.dal.RepasDAO;

public class RepasManager {

	private RepasDAO repasDAO;

	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}

	public void ajouter(Repas repas) throws BusinessException {

		validation(repas);

		try {
			this.repasDAO.insert(repas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Erreur SQL lors de l'injection en base de données");
		}
	}

	private void validation(Repas repas) throws BusinessException {
		// TODO Auto-generated method stub
		if (repas.getDate().isBefore(LocalDate.now())) {
			throw new BusinessException("La date du repas doit etre égale ou supérieure à la date du jour");
		}
		if (repas.getIngredients().size() < 2) {
			throw new BusinessException("Le repas doit avoir au moins 2 aliments");
		}

	}

	public List<Repas> getAll() {
		// TODO Auto-generated method stub
		try {
			return this.repasDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Ingredient> getIngredients(int idRepas) {
		try {
			return this.repasDAO.getIngredients(idRepas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
