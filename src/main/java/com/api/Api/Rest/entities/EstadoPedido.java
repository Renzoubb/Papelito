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



/*Se modela la entidad de estados*/
@Entity
@Table(name = "estado_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class EstadoPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreEstado")
    private String nombreEstado;

    @Column(name="orden")
    private int orden;

    /*Relacion bidireccional entre estadoPedido y pedidoEstado*/
    @OneToMany(mappedBy = "estadoPedido", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<PedidoEstado> pedidoEstadoList = new ArrayList<PedidoEstado>();

}
