package formation.gestionFoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.gestionFoot.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur,Integer> {

}
