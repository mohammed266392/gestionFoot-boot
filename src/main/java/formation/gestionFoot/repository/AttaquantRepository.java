package formation.gestionFoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.gestionFoot.model.Attaquant;

public interface AttaquantRepository extends JpaRepository<Attaquant, Integer>{
	
	@Query("Select d from Attaquant d where d.equipe.id=?1")
	public List<Attaquant> findAllAttaquantByEquipe(Integer id);
}
