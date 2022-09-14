package formation.gestionFoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.gestionFoot.model.Pays;
import formation.gestionFoot.model.Stade;

public interface StadeRepository  extends JpaRepository<Stade, Integer> {
	
	@Query("Select stade from Stade stade where stade.pays = ?1")
	public Optional<Stade> findStadeByPays(Pays pays);
}
