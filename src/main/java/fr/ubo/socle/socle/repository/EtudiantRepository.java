package fr.ubo.socle.socle.repository;

import fr.ubo.socle.socle.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
}