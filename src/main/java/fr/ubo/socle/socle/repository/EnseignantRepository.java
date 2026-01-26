package fr.ubo.socle.socle.repository;

import fr.ubo.socle.socle.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Long getEnseignantById(Integer id);
}