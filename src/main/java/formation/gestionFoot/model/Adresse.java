package formation.gestionFoot.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String numVoie;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String nomVoie;
	
	@Column(columnDefinition = "VARCHAR(12)")
	private String cp;
	
	@Column(columnDefinition = "VARCHAR(60)")
	private String ville;

	
	public Adresse() {
	}
	
	public Adresse(String numVoie, String nomVoie, String cp, String ville) {
		super();
		this.numVoie = numVoie;
		this.nomVoie = nomVoie;
		this.cp = cp;
		this.ville = ville;
	}
	
	public String getNumVoie() {
		return numVoie;
	}
		
	public void setNumVoie(String numVoie) {
		this.numVoie = numVoie;
	}
		
	public String getNomVoie() {
		return nomVoie;
	}	
	
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}	
	
	public String getCp() {
		return cp;
	}	
	
	public void setCp(String cp) {
		this.cp = cp;
	}
		
	public String getVille() {
		return ville;
	}
		
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Adresse [numVoie=" + numVoie + ", nomVoie=" + nomVoie + ", cp=" + cp + ", ville=" + ville + "]";
	}

}
