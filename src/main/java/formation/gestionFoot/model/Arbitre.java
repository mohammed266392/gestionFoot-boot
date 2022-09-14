package formation.gestionFoot.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;


@Entity
public class Arbitre extends Personne {
	
	@JsonView(JsonViews.Base.class)
	private double impartialite;
	
	@JsonView(JsonViews.ArbitreWithMatch.class)
	@OneToMany(mappedBy="arbitre")
	private List<Match> listeMatchArbitres;
	
	public Arbitre(String nom, String prenom, LocalDate naissance, double impartialite){
		super(nom,prenom,naissance);
		this.impartialite = impartialite;
	}
	public Arbitre() {}
	
	public double getImpartialite() {
		return impartialite;
	}

	public void setImpartialite(double impartialite) {
		this.impartialite = impartialite;
	}
	
	public List<Match> getListeMatchArbitres() {
		return listeMatchArbitres;
	}
	
	public void setListeMatchArbitres(List<Match> listeMatchArbitres) {
		this.listeMatchArbitres = listeMatchArbitres;
	}
	
	@Override
	public String toString() {
		return "Arbitre [impartialite=" + impartialite + ", listeMatchArbitres=" + listeMatchArbitres + ", id=" + id
				+ ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
	}

	
}
