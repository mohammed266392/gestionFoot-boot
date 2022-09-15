package formation.gestionFoot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.gestionFoot.model.Match;

public interface MatchRepository extends JpaRepository<Match,Integer> {
	
	@Query("Select match from Match match")
	public List<Match> getAllWithEquipe();
	
	@Query("Select match from Match match where match.compte.id =:idCompte")
	public List<Match> findMatchByIdCompte(@Param("idCompte") Integer idCompte);
	
	
	
	
}
