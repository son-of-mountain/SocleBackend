package fr.ubo.socle.socle.entity.secondary;

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
@Table(name = "CANDIDAT")
public class Candidat {
    @Id
    @Column(name = "NO_ETUDIANT_NAT", nullable = false, length = 50)
    private String noEtudiantNat;

    @Column(name = "ANNEE_PRO", nullable = false, length = 10)
    private String anneePro;

    @Column(name = "SEXE", nullable = false)
    private Boolean sexe = false;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "LIEU_NAISSANCE", nullable = false)
    private String lieuNaissance;

    @Column(name = "SITUATION", nullable = false, length = 3)
    private String situation;

    @ColumnDefault("'Fran��aise'")
    @Column(name = "NATIONALITE", nullable = false, length = 50)
    private String nationalite;

    @Column(name = "TEL_FIXE", length = 20)
    private String telFixe;

    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTU_ADRESSE")
    private String actuAdresse;

    @Column(name = "ACTU_CP", length = 10)
    private String actuCp;

    @Column(name = "ACTU_VILLE")
    private String actuVille;

    @Column(name = "ACTU_PAYS")
    private String actuPays;

    @Column(name = "PERM_ADRESSE", nullable = false)
    private String permAdresse;

    @Column(name = "PERM_CP", nullable = false, length = 10)
    private String permCp;

    @Column(name = "PERM_VILLE", nullable = false)
    private String permVille;

    @Column(name = "PERM_PAYS", nullable = false)
    private String permPays;

    @Column(name = "DERNIER_DIPLOME", nullable = false)
    private String dernierDiplome;

    @Column(name = "UNIVERSITE", nullable = false)
    private String universite;

    @Column(name = "SELECTION_ORIGINE", nullable = false, length = 2)
    private String selectionOrigine;

    @Column(name = "SELECTION_COURANTE", nullable = false, length = 2)
    private String selectionCourante;

    @ColumnDefault("'N'")
    @Column(name = "REPONSE_ILI", nullable = false)
    private Boolean reponseIli = false;

    @Column(name = "DATE_REPONSE_ILI")
    private LocalDate dateReponseIli;

    @ColumnDefault("'NRE'")
    @Column(name = "REPONSE_CAN", length = 3)
    private String reponseCan;

    @Column(name = "DATE_REPONSE_CAN")
    private LocalDate dateReponseCan;

    @Column(name = "NO_ORDRE")
    private Long noOrdre;

}