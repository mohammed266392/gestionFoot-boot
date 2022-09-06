package formation.gestionFoot.model;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Defenseur extends Joueur {
	
	private double tauxInterception;
	private double capaciteRelance;
	
	
	public Defenseur() {
	}
	
	public Defenseur(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique, double mental, int tauxInterception, double capaciteRelance ){
		super(nom, prenom,  naissance, physique,  technique,  tactique,  mental);
		this.tauxInterception = tauxInterception;
		this.capaciteRelance = capaciteRelance;
	}

	public double getTauxInterception() {
		return tauxInterception;
	}

	public void setTauxInterception(double tauxInterception) {
		this.tauxInterception = tauxInterception;
	}

	public double getCapaciteRelance() {
		return capaciteRelance;
	}

	public void setCapaciteRelance(double capaciteRelance) {
		this.capaciteRelance = capaciteRelance;
	}

	@Override
	public String toString() {
		return "Defenseur [physique=" + physique + ", technique=" + technique + ", tactique=" + tactique + ", mental="
				+ mental + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", tauxInterception="
				+ tauxInterception + ", capaciteRelance=" + capaciteRelance + "]";
	}

}
