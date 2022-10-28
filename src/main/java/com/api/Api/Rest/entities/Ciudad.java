package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudad")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Audited
public class Ciudad extends Base{

    @Column(name = "nombreCiudad")
    private String nombreCiudad;

    @Column(name = "codPostal")
    private int codPostal;

    /*
    //relacion con domicilio
    @OneToMany(mappedBy = "fk_ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domicilio> domicilioList = new ArrayList<Domicilio>();*/

    //Relacion con prov
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_provincia")
    private Provincia fk_provincia;

}
