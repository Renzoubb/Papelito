package com.api.Api.Rest.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import javax.persistence.*;
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

    @Column(name="descripcionProducto")
    private String descripcionProducto;

    @Column(name="precioProducto")
    private float precioProducto;

    @ManyToMany
    @JoinTable(
            name="productoCategoria",
            joinColumns = @JoinColumn(name= "producto_id"),
            inverseJoinColumns = @JoinColumn(name= "categoria_id")
    )
    private List<Categoria> categorias;
}
