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
@Table(name="categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Categoria extends Base {

    @Column(name="nombreCategoria")
    private String nombreCategoria;

    /*Relacion bidireccional entre estadoPedido y pedidoEstado
    @OneToMany(mappedBy = "fk_categoria", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productoList = new ArrayList<Producto>();*/
}

