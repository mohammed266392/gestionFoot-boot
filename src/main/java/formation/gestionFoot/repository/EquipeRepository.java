package formation.gestionFoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.gestionFoot.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
	
	@Query("Select equipe from Equipe equipe join fetch equipe.listJoueur where equipe.id=:id")
	public Optional<Equipe> findEquipeWithJoueurs(@Param("id") Integer  id);
	
	@Query("Select equipe from Equipe equipe join fetch equipe.dom where equipe.id=:id")
	public Optional<Equipe> findEquipeWithMatchDom(@Param("id") Integer  id);
	
	@Query("Select equipe from Equipe equipe join fetch equipe.ext where equipe.id=:id")
	public Optional<Equipe> findEquipeWithMatchExt(@Param("id") Integer  id);
	
}



