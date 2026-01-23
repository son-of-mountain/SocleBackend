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
@Table(name = "PROMOTION")
public class Promotion {
    @Id
    @Column(name = "ANNEE_PRO", nullable = false, length = 10)
    private String anneePro;

    @Column(name = "CODE_FORMATION", length = 8)
    private String codeFormation;

    @Column(name = "NO_ENSEIGNANT")
    private Integer noEnseignant;

    @Column(name = "SIGLE_PRO", nullable = false, length = 5)
    private String siglePro;

    @Column(name = "NB_ETU_SOUHAITE", nullable = false)
    private Short nbEtuSouhaite;

    @Column(name = "ETAT_PRESELECTION", nullable = false, length = 3)
    private String etatPreselection;

    @Column(name = "DATE_RENTREE")
    private LocalDate dateRentree;

    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;

    @Column(name = "DATE_REPONSE_LP")
    private LocalDate dateReponseLp;

    @Column(name = "COMMENTAIRE")
    private String commentaire;

    @Column(name = "DATE_REPONSE_LALP")
    private LocalDate dateReponseLalp;

    @ColumnDefault("'RECH'")
    @Column(name = "PROCESSUS_STAGE", length = 5)
    private String processusStage;

    @Column(name = "NO_EVALUATION")
    private Long noEvaluation;

    @Column(name = "NO_BAREME")
    private Long noBareme;

}