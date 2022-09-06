package formation.gestionFoot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import formation.gestionFoot.model.Match;

public interface MatchRepository extends JpaRepository<Match,Integer> {
	
	
}
