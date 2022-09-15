package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.AttaquantException;
import formation.gestionFoot.model.Attaquant;
import formation.gestionFoot.repository.AttaquantRepository;

@Service
public class AttaquantService {

	@Autowired
	private AttaquantRepository attaquantRepo;

	
	
	public List<Attaquant> getAllAttaquantByEquipe(Integer id) {
		return attaquantRepo.findAllAttaquantByEquipe(id);
	}
	public List<Attaquant> getAll() {
		return attaquantRepo.findAll();
	}

	public Attaquant getById(Integer id) {
		return attaquantRepo.findById(id).orElseThrow(AttaquantException::new);
	}

	public Attaquant create(Attaquant attaquant) {
		return attaquantRepo.save(attaquant);
	}

	public Attaquant update(Attaquant attaquant) {
		return attaquantRepo.save(attaquant);
	}

	public void deleteById(Integer id) {
		attaquantRepo.deleteById(id);
	}

}
