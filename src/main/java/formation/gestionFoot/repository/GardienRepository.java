package formation.gestionFoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.gestionFoot.model.Gardien;

public interface GardienRepository  extends JpaRepository<Gardien, Integer> {

}
