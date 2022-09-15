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

import formation.gestionFoot.exception.AttaquantException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Attaquant;
import formation.gestionFoot.service.AttaquantService;


@RestController
@RequestMapping("/api/attaquant")
public class AttaquantRestController {
	
	
	@Autowired
	private AttaquantService attaquantService;
	
	@GetMapping("/equipe/{id}")
	@JsonView(JsonViews.Base.class)
	public List<Attaquant> getAllAttaquantByEquipe(@PathVariable Integer id) {
		
		try {
			return attaquantService.getAllAttaquantByEquipe(id);
			//return defenseurService.getAllDefenseurByEquipe();
		}catch (AttaquantException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Attaquant getById(@PathVariable Integer id) {
		try {
			return attaquantService.getById(id);
		} catch (AttaquantException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Attaquant> getAll() {
		return attaquantService.getAll();
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Attaquant create(@RequestBody Attaquant attaquant) {
		return attaquantService.create(attaquant);
	}
	
	@PutMapping("/{id}")
	public Attaquant update(@RequestBody Attaquant attaquant, @PathVariable Integer id) {
		try {
			Attaquant attaquantEnBase = attaquantService.getById(id);
			if (attaquantEnBase != null) {
				attaquant.setId(id);
			}
		} catch (AttaquantException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return attaquantService.update(attaquant);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
    public Attaquant partialUpdateAttaquant(@RequestBody Map<String, Object> fields,@PathVariable Integer id ) {
        try {
            Attaquant fourni = attaquantService.getById(id);
            fields.forEach((k, v) -> {

                Field field = ReflectionUtils.findField(Attaquant.class, k);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, fourni, v); // ne fonctionne que pour les types standards

            });
            return attaquantService.update(fourni);
        }catch(RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		attaquantService.deleteById(id);
	}
	
}
