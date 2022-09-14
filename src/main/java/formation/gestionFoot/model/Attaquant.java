package formation.gestionFoot.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public class Attaquant extends Joueur {
	
	@JsonView(JsonViews.Base.class)
	private double tauxAssist;
	@JsonView(JsonViews.Base.class)
	private double tauxBut;
	
	
	public Attaquant() {
	}

	public Attaquant(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique,
			double mental, double tauxAssist, double tauxBut) {
		super(nom, prenom, naissance, physique, technique, tactique, mental);
		this.tauxAssist = tauxAssist;
		this.tauxBut = tauxBut;
	}

	public double getTauxAssist() {
		return tauxAssist;
	}

	public void setTauxAssist(double tauxAssist) {
		this.tauxAssist = tauxAssist;
	}

	public double getTauxBut() {
		return tauxBut;
	}

	public void setTauxBut(double tauxBut) {
		this.tauxBut = tauxBut;
	}

	@Override
	public String toString() {
		return "Attaquant [physique=" + physique + ", technique=" + technique + ", tactique=" + tactique + ", mental="
				+ mental + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", tauxAssist="
				+ tauxAssist + ", tauxBut=" + tauxBut + "]";
	}

}
