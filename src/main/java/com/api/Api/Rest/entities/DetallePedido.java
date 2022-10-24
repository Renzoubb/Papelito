package com.api.Api.Rest.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class DetallePedido extends Base {

    @Column(name="subtotal")
    private int subtotal;

    @Column(name="cantidad")
    private int cantidad;

    /*Relacion bidireccional entre pedido y detallePedido*/
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "fk_pedido")
    private Pedido pedido;

    /*Relacion bidireccional entre producto y detallePedido*/
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "fk_producto")
    private Producto producto;

}
