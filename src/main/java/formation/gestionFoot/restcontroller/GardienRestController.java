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

import formation.gestionFoot.exception.GardienException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Gardien;
import formation.gestionFoot.service.GardienService;

@RestController
@RequestMapping("/api/gardien")
public class GardienRestController {
	
	@Autowired
	GardienService gardienService ;
	
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Gardien> getAll() {
		return gardienService.getAll();
	}
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Gardien getById(@PathVariable Integer id) {
		
		try {
			return gardienService.getById(id);
		}catch (GardienException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Gardien create(@RequestBody Gardien gardien) {
		//System.out.println("mon gardient de rest : "+gardien);
		return gardienService.create(gardien);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Gardien update(@RequestBody Gardien Gardien, @PathVariable Integer id) {
		try {
			Gardien GardienEnBase = gardienService.getById(id);
			if (GardienEnBase != null) {
				Gardien.setId(id);
			}
		} catch (GardienException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return gardienService.update(Gardien);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
    public Gardien partialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id ) {
        try {
            Gardien fourni = gardienService.getById(id);
            fields.forEach((k, v) -> {

                Field field = ReflectionUtils.findField(Gardien.class, k);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, fourni, v); // ne fonctionne que pour les types standards

            });
            return gardienService.update(fourni);
        }catch(RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public void delete(@PathVariable Integer id) {
		gardienService.deleteById(id);
	}

}
