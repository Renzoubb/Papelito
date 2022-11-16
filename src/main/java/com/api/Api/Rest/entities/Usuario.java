package com.api.Api.Rest.entities;
import lombok.*;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Usuario extends Base {

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "celular")
    private Long celular;

    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<Rol> roles= new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio fk_domicilio;

    /*
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<Pedido>();*/
}