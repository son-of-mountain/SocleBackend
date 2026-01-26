package fr.ubo.socle.socle.entity.secondary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "DIPLOME")
public class Diplome {
    @Id
    @Column(name = "NO_ETUDIANT_NAT", nullable = false, length = 50)
    private String noEtudiantNat;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @ColumnDefault("'N'")
    @Column(name = "AUTORISATION_ANNUAIRE", nullable = false)
    private Boolean autorisationAnnuaire = false;

    @Column(name = "TYPE_EMPLOI", length = 3)
    private String typeEmploi;

    @Column(name = "MAIL_PRO", length = 100)
    private String mailPro;

    @Column(name = "TEL_PRO", length = 20)
    private String telPro;

    @Column(name = "ADRESSE", length = 100)
    private String adresse;

    @Column(name = "CP", length = 10)
    private String cp;

    @Column(name = "VILLE", length = 50)
    private String ville;

    @Column(name = "EMAIL_PERSO", length = 100)
    private String emailPerso;

    @Column(name = "TEL_PERSO", length = 20)
    private String telPerso;

    @Column(name = "PORTABLE", length = 20)
    private String portable;

}