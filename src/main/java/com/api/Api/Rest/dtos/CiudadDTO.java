package com.api.Api.Rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CiudadDTO {
    private Long id;
    private String nombreCiudad;
    private int codPostal;
    private ProvinciaDTO fk_provincia;
}
