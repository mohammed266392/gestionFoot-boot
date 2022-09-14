package formation.gestionFoot.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public class Entraineur extends Personne {
	
	@JsonView(JsonViews.Base.class)
	private double pedagogie;
	
	@JsonView(JsonViews.Base.class)
	private double experience;
	
	@JsonView(JsonViews.Base.class)
	private double ecoute;
	
	@JsonView(JsonViews.Base.class)
	private double maitriseTechnique;
	
	@JsonView(JsonViews.Base.class)
	private double maitriseTactique;
	
	@JsonView(JsonViews.EntraineurWithEquipe.class)
	@OneToOne
	private Equipe equipe;
	
	
	

	public Entraineur(String nom, String prenom, LocalDate naissance, double pedagogie, double experience,
			double ecoute, double maitriseTechnique, double maitriseTactique) {
		super(nom, prenom, naissance);
		this.pedagogie = pedagogie;
		this.experience = experience;
		this.ecoute = ecoute;
		this.maitriseTechnique = maitriseTechnique;
		this.maitriseTactique = maitriseTactique;
	}

	public Entraineur() {}
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public double getPedagogie() {
		return pedagogie;
	}

	public void setPedagogie(double pedagogie) {
		this.pedagogie = pedagogie;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public double getEcoute() {
		return ecoute;
	}

	public void setEcoute(double ecoute) {
		this.ecoute = ecoute;
	}

	public double getMaitriseTechnique() {
		return maitriseTechnique;
	}

	public void setMaitriseTechnique(double maitriseTechnique) {
		this.maitriseTechnique = maitriseTechnique;
	}

	public double getMaitriseTactique() {
		return maitriseTactique;
	}

	public void setMaitriseTactique(double maitriseTactique) {
		this.maitriseTactique = maitriseTactique;
	}

	@Override
	public String toString() {
		return "Entraineur [nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", pedagogie=" + pedagogie
				+ ", experience=" + experience + ", ecoute=" + ecoute + ", maitriseTechnique=" + maitriseTechnique
				+ ", maitriseTactique=" + maitriseTactique + ", equipe=" + equipe + "]";
	}

	public void coachingEquipe(Equipe e, int pedagogie, int ecoute, int maitriseTechnique, int maitriseTactique) {
		
	}

}
