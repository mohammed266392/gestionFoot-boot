package formation.gestionFoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.gestionFoot.model.Milieu;

public interface MilieuRepository extends JpaRepository<Milieu, Integer>{
	
	@Query("Select d from Milieu d where d.equipe.id=?1")
	public List<Milieu> findAllMilieuByEquipe(Integer id);
	

}
