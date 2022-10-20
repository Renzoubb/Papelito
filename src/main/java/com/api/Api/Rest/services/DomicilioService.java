package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Domicilio;
import com.api.Api.Rest.repositories.CiudadRepository;
import com.api.Api.Rest.repositories.DomicilioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface DomicilioService extends BaseService<Domicilio,Long>{

}
