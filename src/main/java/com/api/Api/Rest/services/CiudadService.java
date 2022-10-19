package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.repositories.CiudadRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService implements BaseService<Ciudad>{

    private CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository){ this.ciudadRepository = ciudadRepository; }

    @Override
    @Transactional
    public List<Ciudad> findAll() throws Exception {
        try {
            List<Ciudad> ciudades = ciudadRepository.findAll();
            return ciudades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ciudad findById(Long id) throws Exception {
        try {
            Optional<Ciudad> entityOptional=  ciudadRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ciudad save(Ciudad entity) throws Exception {
        try {
            entity = ciudadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ciudad update(Long id, Ciudad entity) throws Exception {
        try {
            Optional<Ciudad> entityOptional = ciudadRepository.findById(id);
            Ciudad ciudad = entityOptional.get();
            ciudad = ciudadRepository.save(entity);
            return ciudad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(ciudadRepository.existsById(id)){
                ciudadRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
