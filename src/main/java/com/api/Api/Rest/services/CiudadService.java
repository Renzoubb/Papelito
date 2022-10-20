package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.repositories.CiudadRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface CiudadService extends BaseService<Ciudad, Long>{

}
