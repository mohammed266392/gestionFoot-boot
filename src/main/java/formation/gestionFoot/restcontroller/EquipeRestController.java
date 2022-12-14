package formation.gestionFoot.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.exception.EquipeException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Attaquant;
import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.model.Entraineur;
import formation.gestionFoot.model.Equipe;
import formation.gestionFoot.model.Gardien;
import formation.gestionFoot.model.Joueur;
import formation.gestionFoot.model.Match;
import formation.gestionFoot.model.Milieu;
import formation.gestionFoot.model.Pays;
import formation.gestionFoot.service.AttaquantService;
import formation.gestionFoot.service.DefenseurService;
import formation.gestionFoot.service.EntraineurService;
import formation.gestionFoot.service.EquipeService;
import formation.gestionFoot.service.GardienService;
import formation.gestionFoot.service.MatchService;
import formation.gestionFoot.service.MilieuService;

@RestController
@RequestMapping("/api/equipe")
public class EquipeRestController {
	
	
	@Autowired
	private EquipeService equipeService;
	@Autowired
	private AttaquantService attaquantService;
	
	@Autowired
	private GardienService gardienService;
	@Autowired
	private MilieuService milieuService;
	
	@Autowired
	private DefenseurService defenseurService;
	
	@Autowired
	private EntraineurService entraineurService;
	
	@Autowired
	private MatchService matchService;
	
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Equipe getById(@PathVariable Integer id) {
		try {
			return equipeService.getById(id);
		} catch (EquipeException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Equipe> getAll() {
		return equipeService.getAll();
	}
	@GetMapping("/details")
	@JsonView(JsonViews.EquipeWithJoueurs.class)
	public List<Equipe> getAllWithAll() {
		return equipeService.getAllWithAll();
	}
	@GetMapping("{id}/details")
	@JsonView(JsonViews.EquipeWithJoueurs.class)
	public Equipe getbyIdWithAll(@PathVariable Integer id) {
		return equipeService.getByIdWithJoueurs(id);
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Equipe create(@RequestBody Equipe equipe) {
		return equipeService.create(equipe);
	}
	
	@PostMapping("/{id}/addattaquant/{idAttaquant}")
	@JsonView(JsonViews.EquipeWithJoueurs.class)
	public Equipe addAttaquanttoEquipe(@PathVariable Integer id, @PathVariable Integer idAttaquant) {
		
		Attaquant attaquant = attaquantService.getById(idAttaquant);
		
		Equipe equipe = equipeService.getById(id);
			
		attaquant.setEquipe(equipe);
		
		attaquantService.update(attaquant);
		
		return equipe;
	}
	@PostMapping("/{id}/addGardien/{idGardien}")
	//@JsonView(JsonViews.EquipeWithJoueurs.class)
	@JsonView(JsonViews.JoueurWithEquipe.class)
	public Equipe addGoaltoEquipe(@PathVariable Integer id, @PathVariable Integer idGardien) {
		
		Gardien gardien = gardienService.getById(idGardien);
		
		Equipe equipe = equipeService.getById(id);
			
		gardien.setEquipe(equipe);
		
		gardienService.update(gardien);
		
		return equipe;
	}
	@PostMapping("/{id}/addMilieu/{idMilieu}")
	@JsonView(JsonViews.EquipeWithJoueurs.class)
	public Equipe addMilieutoEquipe(@PathVariable Integer id, @PathVariable Integer idMilieu) {
		
		Milieu milieu = milieuService.getById(idMilieu);
		
		Equipe equipe = equipeService.getById(id);
			
		milieu.setEquipe(equipe);
		
		milieuService.update(milieu);
		
		return equipe;
	}
	@PostMapping("/{id}/addDefenseur/{idDefeseur}")
	@JsonView(JsonViews.EquipeWithJoueurs.class)
	public Equipe addDefenseurtoEquipe(@PathVariable Integer id, @PathVariable Integer idDefeseur) {
		
		Defenseur defenseur = defenseurService.getById(idDefeseur);
		
		Equipe equipe = equipeService.getById(id);
			
		defenseur.setEquipe(equipe);
		
		defenseurService.update(defenseur);
		
		return equipe;
	}
	@PostMapping("/{id}/addentraineur/{idEntraineur}")
	@JsonView(JsonViews.Base.class)
	public Equipe addEntraineurtoEquipe(@PathVariable Integer id, @PathVariable Integer idEntraineur) {
		
		Entraineur entraineur = entraineurService.getById(idEntraineur);
		
		Equipe equipe = equipeService.getById(id);

		equipe.setEntraineur(entraineur);
		
			
		entraineur.setEquipe(equipe);
		
		entraineurService.update(entraineur);
		equipeService.update(equipe);
		
		return equipe;
	}
	
	@PostMapping("/{id}/matchdom")
	@JsonView(JsonViews.EquipeWithMatchDom.class)
	public Equipe createWithMatchDom(@PathVariable Integer id, @RequestBody Match match) {
		
		Equipe equipe = equipeService.getById(id);
		match.setEquipeDom(equipe);
		
		matchService.update(match) ;
		
		return equipeService.getByIdWithMatchDom(id);
	}
	
	@PostMapping("/{id}/matchext")
	@JsonView(JsonViews.EquipeWithMatchExt.class)
	public Equipe createWithMatchExt(@PathVariable Integer id, @RequestBody Match match) {
		
		Equipe equipe = equipeService.getById(id);
		match.setEquipeExt(equipe);
		
		matchService.update(match) ;
		
		return equipeService.getByIdWithMatchExt(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Equipe update(@PathVariable Integer id, @RequestBody Equipe equipe) {
		
		try {
			Equipe equipeEnBase = equipeService.getById(id);
			if(equipeEnBase != null) {
				equipe.setId(id);
			}
		} catch (EquipeException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return equipeService.update(equipe);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Equipe partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Equipe equipe = null;
		try {
			equipe = equipeService.getById(id);
		} catch (EquipeException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		final Equipe e = equipe;
		Pays pays = e.getPays();
		Entraineur entraineur = e.getEntraineur();
		System.out.println("pays de e : " + pays);
		
		fields.forEach((k,v) -> {
			if (k.equals("pays")) {
				Field fieldPays = ReflectionUtils.findField(Pays.class,k);
				ReflectionUtils.makeAccessible(fieldPays);
				ReflectionUtils.setField(fieldPays,pays,(String)v);
				e.setPays(Pays.valueOf((String)v));
			/*}else if(k.equals("entraineur")) {
				((Map<String, Object>) v).forEach((key, value) -> {
					Field fieldEntraineur = ReflectionUtils.findField(Entraineur.class,key);
					ReflectionUtils.makeAccessible(fieldEntraineur);
					ReflectionUtils.setField(fieldEntraineur,entraineur,value);
				});
				e.setEntraineur(entraineur);*/
			}else {
				Field field = ReflectionUtils.findField(Equipe.class,k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, e, v);
			}
		});
		
		return equipeService.update(equipe);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		
		Equipe equipe = equipeService.getById(id);
		List<Joueur> listJoueur = equipe.getListJoueur();
		for (Joueur joueur : listJoueur) {
			joueur.setEquipe(null);
		}
		equipe.setListJoueur(null);
		equipeService.update(equipe);
		equipeService.deleteById(id);
	}
	

}
