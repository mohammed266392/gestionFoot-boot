package formation.gestionFoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.gestionFoot.model.Compte;


public interface CompteRepository extends JpaRepository<Compte,Integer> {
	Optional<Compte> findByLogin(String login);
	Optional<Compte> findByLoginAndPassword(String login, String password);

}
