package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;


/*Se modela la clase intermedia entre pedidos y estados*/
@Entity
@Table(name = "pedido_estado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class PedidoEstado extends Base {

    @Column(name = "vigente")
    private boolean vigente;

    /*Relacion bidireccional entre estadoPedido y pedidoEstado*/
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_estado_pedido")
    private EstadoPedido estadoPedido;

    /*Relacion bidireccional entre pedido y pedidoEstado*/
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;
}

