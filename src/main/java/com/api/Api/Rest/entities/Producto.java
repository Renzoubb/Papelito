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
@Table(name="producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreProducto")
    private String nombreProducto;

    @Column(name="descripcionProducto")
    private String descripcionProducto;

    /*Relacion bidireccional entre producto y detallePedido*/
    @OneToMany(mappedBy = "producto", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();

}
