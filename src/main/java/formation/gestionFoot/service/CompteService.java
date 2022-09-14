package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.CompteException;
import formation.gestionFoot.model.Compte;
import formation.gestionFoot.repository.CompteRepository;


@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	public Compte getById(Integer id) {
		return compteRepo.findById(id).orElseThrow(CompteException::new);
	}

	public Compte create(Compte compte) {
		return compteRepo.save(compte);
	}

	public Compte update(Compte compte) {
		return compteRepo.save(compte);
	}

	public void deleteById(Integer id) {
		compteRepo.deleteById(id);
	}

}
