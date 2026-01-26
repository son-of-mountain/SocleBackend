package fr.ubo.socle.socle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "FORMATION")
public class Formation {
    @Id
    @Column(name = "CODE_FORMATION", nullable = false, length = 8)
    private String codeFormation;

    @Column(name = "DIPLOME", nullable = false, length = 3)
    private String diplome;

    @ColumnDefault("1")
    @Column(name = "N0_ANNEE", nullable = false)
    private Boolean n0Annee = false;

    @Column(name = "NOM_FORMATION", nullable = false, length = 64)
    private String nomFormation;

    @ColumnDefault("'N'")
    @Column(name = "DOUBLE_DIPLOME", nullable = false)
    private String doubleDiplome;

    @Column(name = "DEBUT_HABILITATION")
    private LocalDate debutHabilitation;

    @Column(name = "FIN_HABILITATION")
    private LocalDate finHabilitation;

}