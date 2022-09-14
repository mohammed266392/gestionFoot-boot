package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.EquipeException;
import formation.gestionFoot.model.Equipe;
import formation.gestionFoot.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepo;
	
	
	public Equipe getByIdWithJoueurs(Integer id) {
		return equipeRepo.findEquipeWithJoueurs(id).orElseThrow(EquipeException::new);
	}
	
	public Equipe getByIdWithMatchDom(Integer id) {
		return equipeRepo.findEquipeWithMatchDom(id).orElseThrow(EquipeException::new);
	}
	
	public Equipe getByIdWithMatchExt(Integer id) {
		return equipeRepo.findEquipeWithMatchExt(id).orElseThrow(EquipeException::new);
	}
	
	public List<Equipe> getAll() {
		return equipeRepo.findAll();
	}
	public List<Equipe> getAllWithAll() {
		return equipeRepo.findAllWithAll();
	}


	public Equipe getById(Integer id) {
		return equipeRepo.findById(id).orElseThrow(EquipeException::new);
	}

	public Equipe create(Equipe equipe) {
		
		return equipeRepo.save(equipe);
	}

	public Equipe update(Equipe equipe) {
		return equipeRepo.save(equipe);
	}

	public void deleteById(Integer id) {
		equipeRepo.deleteById(id);
	}
	
}
