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
import formation.gestionFoot.exception.MilieuException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.model.Milieu;
import formation.gestionFoot.service.MilieuService;

@RestController
@RequestMapping("/api/milieu")
public class MilieuRestController {

	@Autowired
	private MilieuService milieuService;
	
	
	@GetMapping("/equipe/{id}")
	@JsonView(JsonViews.Base.class)
	public List<Milieu> getAllMilieuByEquipe(@PathVariable Integer id) {
		
		try {
			return milieuService.getAllMilieuByEquipe(id);
			//return defenseurService.getAllDefenseurByEquipe();
		}catch (MilieuException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Milieu> getAll() {
		return milieuService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Milieu getById(@PathVariable Integer id) {
		try {
			return milieuService.getById(id);
		} catch (MilieuException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Milieu create(@RequestBody Milieu milieu) {
		return milieuService.create(milieu);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Milieu update(@RequestBody Milieu milieu, @PathVariable Integer id) {
		try {
			Milieu milieuEnBase = milieuService.getById(id);
			if (milieuEnBase != null) {
				milieu.setId(id);
			}
		} catch (MilieuException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return milieuService.update(milieu);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Milieu partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		try {
			Milieu milieu = milieuService.getById(id);
			fields.forEach((k, v) -> {
				Field field = ReflectionUtils.findField(Milieu.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, milieu, v); // ne fonctionne que pour les types standards
			});
			return milieuService.update(milieu);
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public void delete(@PathVariable Integer id) {
		milieuService.deleteById(id);
	}

}