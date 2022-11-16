package com.api.Api.Rest.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    private Float subtotal;

    @Column(name="cantidad")
    private Integer cantidad;

    /*Relacion bidireccional entre pedido y detallePedido*/
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name =  "fk_pedido")
    private Pedido pedido;

    /*Relacion bidireccional entre producto y detallePedido*/
    @ManyToOne(optional = false)
    @JoinColumn(name =  "fk_producto")
    private Producto producto;

}
