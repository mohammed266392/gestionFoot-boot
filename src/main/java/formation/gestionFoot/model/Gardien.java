package formation.gestionFoot.model;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Gardien extends Joueur{
	
	
	protected double tauxArret;
	protected double tauxJeuPied;
	
	public Gardien(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique, double mental, double tauxArret, double tauxJeuPied ){
		super(nom, prenom,  naissance, physique,  technique,  tactique,  mental);
		this.tauxArret = tauxArret;
		this.tauxJeuPied = tauxJeuPied;
		
	}
	public Gardien() {}
	

	public double getNbArret() {
		return tauxArret;
	}

	public void setNbArret(int nbArret) {
		this.tauxArret = nbArret;
	}

	public double getJeuPied() {
		return tauxArret;
	}

	
	public void setJeuPied(int jeuPied) {
		this.tauxArret = jeuPied;
	}
	
	@Override
	public String toString() {
		return "Gardien [tauxArret=" + tauxArret + ", tauxJeuPied=" + tauxJeuPied + ", physique=" + physique
				+ ", technique=" + technique + ", tactique=" + tactique + ", mental=" + mental + ", equipe=" + equipe
				+ ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
	}

}