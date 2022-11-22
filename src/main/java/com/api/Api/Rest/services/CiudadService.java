package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Ciudad;

import java.util.List;


public interface CiudadService extends BaseService<Ciudad, Long>{
    List<Ciudad> getCiudadesByProvincia(Long idProvincia) throws Exception;

}
