package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.ArbitreException;
import formation.gestionFoot.model.Arbitre;
import formation.gestionFoot.repository.ArbitreRepository;


@Service
public class ArbitreService {
	
	@Autowired
	private ArbitreRepository arbitreRepo;
	

	public List<Arbitre> getAll() {
		return arbitreRepo.findAll();
	}
	
	public List<Arbitre> getAllWithMatch() {
		return arbitreRepo.findAllWithMatch();
	}

	public Arbitre getById(Integer id) {
		return arbitreRepo.findById(id).orElseThrow(ArbitreException::new);
	}

	public Arbitre create(Arbitre arbitre) {
		return arbitreRepo.save(arbitre);
	}

	public Arbitre update(Arbitre arbitre) {
		return arbitreRepo.save(arbitre);
	}

	public void deleteById(Integer id) {
		arbitreRepo.deleteById(id);
	}

}
