package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Pedido extends Base {

    @Column(name="fecha")
    private Date fecha;

    @Column(name="total")
    private Float total;

    @Column(name="direccionEnvio")
    private String direccionEnvio;

    /*CascadeType. y orphanRemoval = true :
    cuando eliminemos un pedido tambn se van a eliminar los detalles o cuando creemos un pedido tambn se creen los detalles*/
    /*Relacion unidireccional: se crea automaticamente una tabla intermedia que relaciona el detalle del pedido y el pedido/
    /*@OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();*/

    /*Relacion bidireccional entre pedido y detallePedido*/

    /*relaciono muchos pedidos con un usuario bidireccionalmente*/
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
}
