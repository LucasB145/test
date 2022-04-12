package fr.eni.javaee.dal;

public abstract class DAOFactory {

	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl();
	}
}
