package fr.ubo.socle.socle.entity.secondary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYE")
public class Employe {
    @Id
    @Column(name = "NO_CONTACT_ILI", nullable = false)
    private Long id;

    @Column(name = "NO_ENTREPRISE", nullable = false)
    private Long noEntreprise;

    @Column(name = "NO_ETUDIANT_NAT", length = 50)
    private String noEtudiantNat;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Column(name = "MAIL_PRO", length = 100)
    private String mailPro;

    @Column(name = "TEL_PRO", length = 20)
    private String telPro;

    @Column(name = "FONCTION", length = 5)
    private String fonction;

}