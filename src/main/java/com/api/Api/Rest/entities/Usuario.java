package com.api.Api.Rest.entities;
import lombok.*;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "contrasenia")
    private String contraseña;

    @Column(name = "celular")
    private Long celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio fk_domicilio;

    /*
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<Pedido>();*/
}