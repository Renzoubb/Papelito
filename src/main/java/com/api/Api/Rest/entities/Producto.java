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
@Table(name="producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Producto extends Base {

    @Column(name="nombreProducto")
    private String nombreProducto;

    @Column(name="descripcionProducto",columnDefinition = "TEXT")
    private String descripcionProducto;

    @Column(name="precioProducto")
    private Float precioProducto;

    @Column(name="imageProducto")
    private String imageProducto;

    @Column(name="destacado")
    private Boolean destacado;

    @Column(name="oferta")
    private Boolean oferta;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

}
