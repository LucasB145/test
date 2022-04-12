package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.bo.Ingredient;
import fr.eni.javaee.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {

	private static final String INSERT_REPAS = "INSERT INTO REPAS(date, heure) VALUES(?,?);";
	private static final String INSERT_INGREDIENT = "INSERT INTO INGREDIENT(nom, id_repas) VALUES(?,?);";
	private static final String SELECT_REPAS = "SELECT * FROM REPAS;";
	private static final String SELECT_INGREDIENTS = "SELECT * FROM INGREDIENT WHERE id_repas=?;";

	@Override
	public List<Ingredient> getIngredients(int idRepas) throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt = cnx.prepareStatement(SELECT_INGREDIENTS);
		pstmt.setInt(1, idRepas);
		ResultSet rs = pstmt.executeQuery();

		List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
		while (rs.next()) {
			String nomIngredient = rs.getString("nom");
			Ingredient ingredient = new Ingredient(nomIngredient);
			listeIngredients.add(ingredient);
		}
		return listeIngredients;
	}

	@Override
	public List<Repas> getAll() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_REPAS);
		List<Repas> listeRepas = new ArrayList<Repas>();
		while (rs.next()) {
			Repas repas = new Repas(rs.getInt("id"), rs.getDate("date").toLocalDate(),
					rs.getTime("heure").toLocalTime());
			listeRepas.add(repas);
		}
		return listeRepas;
	}

	@Override
	public void insert(Repas repas) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setDate(1, Date.valueOf(repas.getDate()));
			pstmt.setTime(2, Time.valueOf(repas.getHeure()));
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				repas.setId(rs.getInt(1));
			}
			for (Ingredient i : repas.getIngredients()) {
				addAliment(repas, i, cnx);
			}
			cnx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addAliment(Repas repas, Ingredient ingredient, Connection cnx) throws SQLException {
		PreparedStatement pstmt2 = cnx.prepareStatement(INSERT_INGREDIENT, PreparedStatement.RETURN_GENERATED_KEYS);
		String libelleIngredient = ingredient.getLibelle();
		pstmt2.setString(1, libelleIngredient);
		pstmt2.setInt(2, repas.getId());
		pstmt2.executeUpdate();
	}

}
