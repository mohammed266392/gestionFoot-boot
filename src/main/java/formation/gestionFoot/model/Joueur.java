package formation.gestionFoot.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public abstract class Joueur extends Personne {
	
	@JsonView(JsonViews.Base.class)
	protected double physique;
	
	@JsonView(JsonViews.Base.class)
	protected double technique;
	
	@JsonView(JsonViews.Base.class)
	protected double tactique;
	
	@JsonView(JsonViews.Base.class)
	protected double mental;
	
	@ManyToOne
	protected Equipe equipe;
	
	
	
	public Joueur(String nom, String prenom, LocalDate naissance, double physique, double technique, double tactique, double mental){
		super(nom, prenom, naissance);
		this.physique = physique ;
		this.technique = technique;
		this.tactique = tactique;
		this.mental = mental;
	}
	public Joueur() {}

	public double getPhysique() {
		return physique;
	}

	public void setPhysique(double physique) {
		this.physique = physique;
	}

	public double getTechnique() {
		return technique;
	}

	public void setTechnique(double technique) {
		this.technique = technique;
	}

	public double getTactique() {
		return tactique;
	}

	public void setTactique(double tactique) {
		this.tactique = tactique;
	}

	public double getMental() {
		return mental;
	}

	public void setMental(double mental) {
		this.mental = mental;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	@Override
	public String toString() {
		return "Joueur [physique=" + physique + ", technique=" + technique + ", tactique=" + tactique + ", mental="
				+ mental + ", equipe=" + equipe + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance="
				+ naissance + "]";
	}
	

}
