package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Audited
public class Provincia extends Base {

    //Atributos. Extiende de base donde contiene el ID por eso no esta dentro de la clase
    @Column(name = "nombreCategoria")
    private String nombreCategoria;


    @OneToMany(mappedBy = "fk_provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ciudad> ciudadList = new ArrayList<Ciudad>();

}
