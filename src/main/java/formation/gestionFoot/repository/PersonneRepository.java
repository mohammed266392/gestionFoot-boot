package formation.gestionFoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.gestionFoot.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {

}
