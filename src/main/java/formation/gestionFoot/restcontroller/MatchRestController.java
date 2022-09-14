package formation.gestionFoot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.exception.MatchException;
import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Arbitre;
import formation.gestionFoot.model.Match;
import formation.gestionFoot.service.ArbitreService;
import formation.gestionFoot.service.MatchService;

@RestController
@RequestMapping("/api/match")
public class MatchRestController {
	
	@Autowired
	private MatchService matchService;
	
	
	@JsonView(JsonViews.Base.class)
	@GetMapping("")
	public List<Match> getAll() {
		return matchService.getAll();
	}
	@JsonView(JsonViews.MatchWithEquipe.class)
	@GetMapping("/details")
	public List<Match> getAllWhithEquipe() {
		return matchService.getAll();
	}
	

	@JsonView(JsonViews.Base.class)
	@GetMapping("/{id}")
	public Match getById(@PathVariable Integer id) {
		try {
			return matchService.getById(id);
		} catch (MatchException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Match create(@RequestBody Match match) {
		return matchService.create(match);
	}
	
	@PostMapping("/{id}/addarbitre")
	@JsonView(JsonViews.MatchWithArbitre.class)
	public Match create(@PathVariable Integer id, @RequestBody Arbitre arbitre) {
		
		Match match = matchService.getById(id);
		match.setArbitre(arbitre);
		
		matchService.update(match);

				
		return matchService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		matchService.deleteById(id);
	}
	
	
}
