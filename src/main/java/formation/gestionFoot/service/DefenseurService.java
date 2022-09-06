package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.DefenseurException;
import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.repository.DefenseurRepository;


@Service
public class DefenseurService {
	
	@Autowired
	private DefenseurRepository defenseurRepo;
	

	public List<Defenseur> getAll() {
		return defenseurRepo.findAll();
	}

	public Defenseur getById(Integer id) {
		return defenseurRepo.findById(id).orElseThrow(DefenseurException::new);
	}

	public Defenseur create(Defenseur defenseur) {
		return defenseurRepo.save(defenseur);
	}

	public Defenseur update(Defenseur defenseur) {
		return defenseurRepo.save(defenseur);
	}

	public void deleteById(Integer id) {
		defenseurRepo.deleteById(id);
	}

}
