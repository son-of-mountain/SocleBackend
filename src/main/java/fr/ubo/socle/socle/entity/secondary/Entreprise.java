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
@Table(name = "ENTREPRISE")
public class Entreprise {
    @Id
    @Column(name = "NO_ENTREPRISE", nullable = false)
    private Long id;

    @ColumnDefault("'N'")
    @Column(name = "REFERENCEE")
    private Boolean referencee;

    @Column(name = "DATE_REFERENCEMENT")
    private LocalDate dateReferencement;

    @Column(name = "LOGIN_CREA", length = 8)
    private String loginCrea;

    @ColumnDefault("SYSDATE")
    @Column(name = "DATE_CREA", nullable = false)
    private LocalDate dateCrea;

    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @Column(name = "SIEGE_SOCIAL", nullable = false, length = 100)
    private String siegeSocial;

    @Column(name = "DOMAINE_ACTIVITE", nullable = false, length = 5)
    private String domaineActivite;

    @Column(name = "ADRESSE", nullable = false)
    private String adresse;

    @Column(name = "CP", nullable = false, length = 10)
    private String cp;

    @Column(name = "VILLE", nullable = false, length = 100)
    private String ville;

    @ColumnDefault("'FRANCE'")
    @Column(name = "PAYS", nullable = false, length = 100)
    private String pays;

    @Column(name = "TEL", nullable = false, length = 20)
    private String tel;

    @Column(name = "SITE_INTERNET", length = 150)
    private String siteInternet;

    @Column(name = "NOM_REPRESENTANT", length = 50)
    private String nomRepresentant;

    @Column(name = "PRENOM_REPRESENTANT", length = 50)
    private String prenomRepresentant;

    @Column(name = "LOGIN_MAJ", length = 8)
    private String loginMaj;

    @ColumnDefault("SYSDATE")
    @Column(name = "DATE_MAJ")
    private LocalDate dateMaj;

    @ColumnDefault("'N'")
    @Column(name = "OFFRE_STAGE")
    private Boolean offreStage;

}