package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

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

}
