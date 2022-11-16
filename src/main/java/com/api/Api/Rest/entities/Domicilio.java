package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Audited
public class Domicilio extends Base{

    //Atributos
    @Column(name = "nombreCalle")
    private String nombreCalle;

    @Column(name = "numCalle")
    private int numCalle;

    @Column(name = "numDpto")
    private int numDpto;

    @Column(name = "piso")
    private String piso;

    //Relacion
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_ciudad")
    private Ciudad fk_ciudad;

    /*
    //Mari
    @OneToOne(mappedBy = "fk_domicilio")
    private Usuario usuario;
    */
}
