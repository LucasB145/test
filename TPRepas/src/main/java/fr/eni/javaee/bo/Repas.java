package fr.eni.javaee.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Repas {
	// Attributs
	int id;
	LocalDate date;
	LocalTime heure;

	List<Ingredient> ingredients;

	// Constructeurs
	public Repas(LocalDate date, LocalTime heure, List<Ingredient> ingredients) {
		super();
		this.date = date;
		this.heure = heure;
		this.ingredients = ingredients;
	}

	public Repas() {
		super();
	}

	public Repas(LocalDate date, LocalTime heure) {
		super();
		this.date = date;
		this.heure = heure;
	}

	public Repas(int id, LocalDate date, LocalTime heure) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
	}

	// Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient i) {
		this.ingredients.add(i);
	}

	@Override
	public String toString() {
		return "Repas [date=" + date + ", heure=" + heure + ", ingredients=" + ingredients + "]";
	}

}
