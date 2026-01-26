package fr.ubo.socle.socle.entity.secondary;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "POSTE_ENTREPRISE")
public class PosteEntreprise {
    @EmbeddedId
    private PosteEntrepriseId id;

    @Column(name = "FONCTION", nullable = false, length = 5)
    private String fonction;

    @Column(name = "DATE_EMBAUCHE", nullable = false)
    private LocalDate dateEmbauche;

    @Column(name = "MOYEN_OBTENTION", nullable = false, length = 3)
    private String moyenObtention;

    @Column(name = "SERVICE", length = 5)
    private String service;

    @Column(name = "BRUT_ANNUEL")
    private Integer brutAnnuel;

}