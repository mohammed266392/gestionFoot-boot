package formation.gestionFoot.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.gestionFoot.jsonviews.JsonViews;
import formation.gestionFoot.model.Equipe;
import formation.gestionFoot.model.Pays;
import formation.gestionFoot.model.Stade;
import formation.gestionFoot.service.StadeService;

@RestController
@RequestMapping("/api/stade")
public class StadeRestController {
	
	@Autowired
	private StadeService stadeService;
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Stade> getAll(){
		return stadeService.getAll() ;
	}
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Stade  create(@RequestBody Stade stade){
		return stadeService.create(stade) ;
	}
	
	@GetMapping("/{pays}")
	@JsonView(JsonViews.Base.class)
	public Stade getStadeByPays(@PathVariable Pays pays) {
		return stadeService.getByPays(pays) ;
	}

}
