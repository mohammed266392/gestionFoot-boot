package formation.gestionFoot.model;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public class Gardien extends Joueur{
	
	@JsonView(JsonViews.Base.class)
	protected double tauxArret;
	
	@JsonView(JsonViews.Base.class)
	protected double tauxJeuPied;
	
	public Gardien(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique, double mental, double tauxArret, double tauxJeuPied ){
		super(nom, prenom,  naissance, physique,  technique,  tactique,  mental);
		this.tauxArret = tauxArret;
		this.tauxJeuPied = tauxJeuPied;
		
	}
	
	public Gardien() {}
	
	public double getTauxArret() {
		return tauxArret;
	}

	public void setTauxArret(double tauxArret) {
		this.tauxArret = tauxArret;
	}

	public double getTauxJeuPied() {
		return tauxJeuPied;
	}

	public void setTauxJeuPied(double tauxJeuPied) {
		this.tauxJeuPied = tauxJeuPied;
	}

	@Override
	public String toString() {
		return "Gardien [tauxArret=" + tauxArret + ", tauxJeuPied=" + tauxJeuPied + ", physique=" + physique
				+ ", technique=" + technique + ", tactique=" + tactique + ", mental=" + mental + ", equipe=" + equipe
				+ ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
	}

}