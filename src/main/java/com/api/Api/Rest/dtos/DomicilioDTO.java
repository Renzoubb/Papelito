package com.api.Api.Rest.dtos;


import com.api.Api.Rest.entities.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {
    private Long id;
    private String nombreCalle;
    private int numCalle;
    private int numDpto;
    private String piso;
    private CiudadDTO fk_ciudad;
}
