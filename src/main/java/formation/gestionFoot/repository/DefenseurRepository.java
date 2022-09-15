package formation.gestionFoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.model.Match;

public interface DefenseurRepository extends JpaRepository<Defenseur, Integer>{
	
	
	
	//@Query("Select defenseur from Defenseur defenseur join fetch defenseur.equipe.id 27 ")
	//public List<Defenseur> findAllDefenseurByEquipe(@Param("idEquipe") Integer idEquipe);
	@Query("Select d from Defenseur d where d.equipe.id=?1")
	public List<Defenseur> findAllDefenseurByEquipe(Integer id);
	

	
	
}
