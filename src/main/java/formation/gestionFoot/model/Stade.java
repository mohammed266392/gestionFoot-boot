package formation.gestionFoot.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public class Stade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Base.class)
	private Integer id;
	
	
	@Column(length = 100, nullable = false)
	@JsonView(JsonViews.Base.class)
	private String nom;
	
	
	@Column(nullable = false)
	@JsonView(JsonViews.Base.class)
	private Integer capacite;
	
	@Embedded // erreur a partir de la classe addresse.
	@JsonView(JsonViews.Base.class)
	private Adresse adresse;
	
	@Column(length = 10)
	@JsonView(JsonViews.Base.class)
	private double ambiance;
	
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Base.class)
	private Pays pays;
	
	

	public Stade(String nom, Integer capacite, Adresse adresse, double ambiance, Pays pays) {
		this.nom = nom;
		this.capacite = capacite;
		this.adresse = adresse;
		this.ambiance = ambiance;
		this.pays = pays;
	}
	
	public Stade() {	
	}


	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	public double getAmbiance() {
		return ambiance;
	}

	public void setAmbiance(double ambiance) {
		this.ambiance = ambiance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	
}
