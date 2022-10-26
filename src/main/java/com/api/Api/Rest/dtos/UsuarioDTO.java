package com.api.Api.Rest.dtos;

import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.Domicilio;
import com.api.Api.Rest.entities.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String apellido;
    private String email;
    private Long celular;
    private DomicilioDTO fk_domicilio;
}
