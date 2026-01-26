package fr.ubo.socle.socle.repository;

import fr.ubo.socle.socle.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends  JpaRepository<Formation, String> {
}
