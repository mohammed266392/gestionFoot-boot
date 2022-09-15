package formation.gestionFoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.gestionFoot.model.Compte;
import formation.gestionFoot.model.Equipe;


public interface CompteRepository extends JpaRepository<Compte,Integer> {
	Optional<Compte> findByLogin(String login);
	Optional<Compte> findByLoginAndPassword(String login, String password);
	
	@Query("Select compte from Compte compte join fetch compte.equipe where compte.id=:id")
	Optional<Compte>findByIdWithEquipe(@Param("id") Integer  id);

}
