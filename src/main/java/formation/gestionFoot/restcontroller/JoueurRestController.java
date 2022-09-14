package formation.gestionFoot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.exception.ArbitreException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Joueur;
import formation.gestionFoot.service.JoueurService;


@RestController
@RequestMapping("/api/joueur")
public class JoueurRestController {
	
	
	@Autowired
	private JoueurService joueurService;
	
	@JsonView(JsonViews.Base.class)
	@GetMapping("")
	public List<Joueur> getAll() {
		try {
			return joueurService.getAll();
		} catch (ArbitreException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
