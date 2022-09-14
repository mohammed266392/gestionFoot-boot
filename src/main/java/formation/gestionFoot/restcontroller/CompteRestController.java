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
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Compte;
import formation.gestionFoot.repository.CompteRepository;
import formation.gestionFoot.restcontroller.dto.LoginDTO;
import formation.gestionFoot.service.CompteService;


@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private CompteRepository compteRepo;
	
	@JsonView(JsonViews.Base.class)
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Integer id) {
		try {
			return compteService.getById(id);
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*@JsonView(JsonViews.Base.class)
	@GetMapping("/{login}")
	public Optional<Compte> getByLogin(@PathVariable String login) {
		try {
			return compteRepo.findByLogin(login);
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}*/
	
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
    public Compte partialUpdateCompte(@RequestBody Map<String, Object> fields,@PathVariable Integer id ) {
        try {
            Compte fourni = compteService.getById(id);
            fields.forEach((k, v) -> {

                Field field = ReflectionUtils.findField(Compte.class, k);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, fourni, v); // ne fonctionne que pour les types standards

            });
            return compteService.update(fourni);
        }catch(RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		compteService.deleteById(id);
	}
	
	
	@PostMapping("/login")
	public Compte login(@RequestBody LoginDTO loginDTO) {
		Optional<Compte> optionalCompte = compteRepo.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getPassword());
		
		if(!optionalCompte.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Utilisateur inconnu");
		}
		
		return optionalCompte.get();
	}
	
}
