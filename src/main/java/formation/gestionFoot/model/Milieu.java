package formation.gestionFoot.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Milieu extends Joueur {
	
	
	@Column(length = 10, nullable = false)
	private double tauxEspace;
	
	@Column(length = 10, nullable = false)
	private double tauxTransmissionAttaquant;

	public Milieu(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique,
		double mental, double tauxEspace, double tauxTransmissionAttaquant) {
		super(nom, prenom, naissance, physique, technique, tactique, mental);
		this.tauxEspace = tauxEspace;
		this.tauxTransmissionAttaquant = tauxTransmissionAttaquant;
	}

	public Milieu() {}
	
	public double getTauxEspace() {
		return tauxEspace;
	}

	public void setTauxEspace(double tauxEspace) {
		this.tauxEspace = tauxEspace;
	}

	public double getTauxTransmissionAttaquant() {
		return tauxTransmissionAttaquant;
	}

	public void setTauxTransmissionAttaquant(double tauxTransmissionAttaquant) {
		this.tauxTransmissionAttaquant = tauxTransmissionAttaquant;
	}

	@Override
	public String toString() {
		return "Milieu [tauxEspace=" + tauxEspace + ", tauxTransmissionAttaquant=" + tauxTransmissionAttaquant
				+ ", physique=" + physique + ", technique=" + technique + ", tactique=" + tactique + ", mental="
				+ mental + ", equipe=" + equipe + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance="
				+ naissance + "]";
	}
	
	

}


