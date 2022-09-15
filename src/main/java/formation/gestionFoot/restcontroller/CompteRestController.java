package formation.gestionFoot.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import formation.gestionFoot.exception.CompteException;
import formation.gestionFoot.exception.EquipeException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Compte;
import formation.gestionFoot.model.Entraineur;
import formation.gestionFoot.model.Equipe;
import formation.gestionFoot.model.Pays;
import formation.gestionFoot.repository.CompteRepository;
import formation.gestionFoot.restcontroller.dto.LoginDTO;
import formation.gestionFoot.service.CompteService;
import formation.gestionFoot.service.EquipeService;


@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private EquipeService equipeService;
	
	@JsonView(JsonViews.Base.class)
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Integer id) {
		try {
			return compteService.getById(id);
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("{id}/equipe")
	@JsonView(JsonViews.CompteWithEquipe.class)
	public Compte getByIdWithEquipe(@PathVariable Integer id) {
		return compteService.getByIdWithEquipe(id);
	}
	
	@JsonView(JsonViews.Base.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteService.getAll();
	}
	
	@JsonView(JsonViews.Base.class)
	@PostMapping("")
	public Compte create(@RequestBody Compte compte) {
		return compteService.create(compte);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Compte update(@RequestBody Compte compte, @PathVariable Integer id) {
		try {
			Compte compteEnBase = compteService.getById(id);
			if (compteEnBase != null) {
				compte.setId(id);
			}
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteService.update(compte);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	//@JsonView(JsonViews.CompteWithEquipe.class)
    public Compte partialUpdateCompte(@RequestBody Map<String, Object> fields,@PathVariable Integer id ) {
		Compte compte = null;
		try {
			compte = compteService.getById(id);
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		final Compte c = compte;
		Equipe equipe = c.getEquipe();
		
        try {
            //Compte fourni = compteService.getByIdWithEquipe(id);
        	Compte fourni = compteService.getById(id);
            fields.forEach((k, v) -> {
            	
            	if (k.equals("equipe")) {
    				Field fieldEquipe = ReflectionUtils.findField(Equipe.class,k);
    				ReflectionUtils.makeAccessible(fieldEquipe);
    				ReflectionUtils.setField(fieldEquipe,equipe,(Equipe)v);
    				c.setEquipe((Equipe)v);
    			/*}else if(k.equals("entraineur")) {
    				((Map<String, Object>) v).forEach((key, value) -> {
    					Field fieldEntraineur = ReflectionUtils.findField(Entraineur.class,key);
    					ReflectionUtils.makeAccessible(fieldEntraineur);
    					ReflectionUtils.setField(fieldEntraineur,entraineur,value);
    				});
    				e.setEntraineur(entraineur);*/
    			
    			}else {

                Field field = ReflectionUtils.findField(Compte.class, k);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, fourni, v); // ne fonctionne que pour les types standards
    			}
            });
            return compteService.update(fourni);
        }catch(RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public void delete(@PathVariable Integer id) {
		compteService.deleteById(id);
	}
	
	
	@PostMapping("/login")
	@JsonView(JsonViews.CompteWithEquipe.class)
	public Compte login(@RequestBody LoginDTO loginDTO) {
		Optional<Compte> optionalCompte = compteRepo.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getPassword());
		
		if(!optionalCompte.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Utilisateur inconnu");
		}
		
		return optionalCompte.get();
	}
	
	@PatchMapping("{idCompte}/equipe/{idEquipe}")
	@JsonView(JsonViews.CompteWithEquipe.class)
	public Compte patchCompteToEquipe(@PathVariable Integer idCompte,@PathVariable Integer idEquipe) {
		
		Equipe equipe = equipeService.getById(idEquipe);
		
		Compte compte = compteService.getById(idCompte)	;	
		
		compte.setEquipe(equipe);
		compteService.update(compte);
		
		return compte;
	}
	
}
