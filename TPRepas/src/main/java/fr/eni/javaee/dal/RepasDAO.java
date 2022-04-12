package fr.eni.javaee.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.javaee.bo.Ingredient;
import fr.eni.javaee.bo.Repas;

public interface RepasDAO {

	public void insert(Repas repas) throws SQLException;

	public List<Repas> getAll() throws SQLException;

	public List<Ingredient> getIngredients(int idRepas) throws SQLException;

}
