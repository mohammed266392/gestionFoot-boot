package formation.gestionFoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;

@Entity
public class Compte {
	
	 @JsonView(JsonViews.Base.class)
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @JsonView(JsonViews.Base.class)
	 @Column(length = 20, nullable = false, unique = true)
	 private String login;
	 
	 @JsonView(JsonViews.Base.class)
	 @Column(length = 120, nullable = false)
	 private String password;

	 @JsonView(JsonViews.Base.class)
	 private String email;
	 
	 @JsonView(JsonViews.Base.class)
	 @Column(nullable = false)
	 private Boolean hasEquipe = false;
	 
	 //@JsonView(JsonViews.CompteWithEquipe.class)
	 @JsonView(JsonViews.Base.class)
	 @OneToOne
	 private Equipe equipe;
		


	public Compte(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.hasEquipe = false;

	}

	public Compte() {}
	

	public Boolean getHasEquipe() {
		return hasEquipe;
	}

	public void setHasEquipe(Boolean hasEquipe) {
		this.hasEquipe = hasEquipe;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe v) {
		this.equipe = v;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}
	

}
