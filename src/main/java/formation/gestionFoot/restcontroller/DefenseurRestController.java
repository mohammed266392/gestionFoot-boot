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

import formation.gestionFoot.exception.DefenseurException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.service.DefenseurService;

@RestController
@RequestMapping("/api/defenseur")
public class DefenseurRestController {
	
	@Autowired
	private DefenseurService defenseurService;
	
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Defenseur> getAll() {
		return defenseurService.getAll();
	}
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Defenseur getById(@PathVariable Integer id) {
		
		try {
			return defenseurService.getById(id);
		}catch (DefenseurException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Defenseur create(@RequestBody Defenseur defenseur) {
		return defenseurService.create(defenseur);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Defenseur update(@RequestBody Defenseur defenseur, @PathVariable Integer id) {
		try {
			Defenseur DefenseurEnBase = defenseurService.getById(id);
			if (DefenseurEnBase != null) {
				defenseur.setId(id);
			}
		} catch (DefenseurException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return defenseurService.update(defenseur);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
    public Defenseur partialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id ) {
        try {
            Defenseur fourni = defenseurService.getById(id);
            fields.forEach((k, v) -> {

                Field field = ReflectionUtils.findField(Defenseur.class, k);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, fourni, v); // ne fonctionne que pour les types standards

            });
            return defenseurService.update(fourni);
        }catch(RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public void delete(@PathVariable Integer id) {
		defenseurService.deleteById(id);
	}
}
