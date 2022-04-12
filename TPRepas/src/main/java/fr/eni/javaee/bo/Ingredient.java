package fr.eni.javaee.bo;

public class Ingredient {
	int id;

	String libelle;

	public Ingredient(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Ingredient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}

}
