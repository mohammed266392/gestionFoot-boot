package formation.gestionFoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.gestionFoot.model.Arbitre;

public interface ArbitreRepository  extends JpaRepository<Arbitre, Integer> {
	
	@Query("Select arbitre, arbitre.listeMatchArbitres  from Arbitre arbitre left join fetch arbitre.listeMatchArbitres ")
	public List<Arbitre> findAllWithMatch();

}
