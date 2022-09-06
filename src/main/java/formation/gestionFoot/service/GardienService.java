package formation.gestionFoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.gestionFoot.exception.GardienException;
import formation.gestionFoot.model.Gardien;
import formation.gestionFoot.repository.GardienRepository;


@Service
public class GardienService {
	
	@Autowired
	private GardienRepository gardienRepo;
	

	public List<Gardien> getAll() {
		return gardienRepo.findAll();
	}

	public Gardien getById(Integer id) {
		return gardienRepo.findById(id).orElseThrow(GardienException::new);
	}

	public Gardien create(Gardien gardien) {
		return gardienRepo.save(gardien);
	}

	public Gardien update(Gardien gardien) {
		return gardienRepo.save(gardien);
	}

	public void deleteById(Integer id) {
		gardienRepo.deleteById(id);
	}

}
