package fr.ubo.socle.socle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ELEMENT_CONSTITUTIF")
public class ElementConstitutif {
    @EmbeddedId
    private ElementConstitutifId id;

    @Column(name = "NO_ENSEIGNANT", nullable = false)
    private Integer noEnseignant;

    @Column(name = "DESIGNATION", nullable = false, length = 64)
    private String designation;

    @Column(name = "DESCRIPTION", nullable = false, length = 240)
    private String description;

    @Column(name = "NBH_CM")
    private Short nbhCm;

    @Column(name = "NBH_TD")
    private Short nbhTd;

    @Column(name = "NBH_TP")
    private Short nbhTp;

}