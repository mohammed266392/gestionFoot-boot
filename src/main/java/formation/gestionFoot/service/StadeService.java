package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.MilieuException;
import formation.gestionFoot.exception.StadeException;
import formation.gestionFoot.model.Milieu;
import formation.gestionFoot.model.Pays;
import formation.gestionFoot.model.Stade;
import formation.gestionFoot.repository.StadeRepository;

@Service
public class StadeService {
	
	@Autowired
	private StadeRepository stadeRepository;
	
	
	public List<Stade> getAll() {
		return stadeRepository.findAll();
	}

	public Stade getById(Integer id) {
		return stadeRepository.findById(id).orElseThrow(MilieuException::new);
	}

	public Stade create(Stade stade) {
		return stadeRepository.save(stade);
	}

		
	public Stade getByPays(Pays pays) {
		
		return stadeRepository.findStadeByPays(pays).orElseThrow(StadeException::new);
		
	}
}
