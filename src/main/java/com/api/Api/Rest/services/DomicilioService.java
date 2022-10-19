package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Domicilio;
import com.api.Api.Rest.repositories.CiudadRepository;
import com.api.Api.Rest.repositories.DomicilioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements BaseService<Domicilio>{

    private DomicilioRepository domicilioRepository;

    public DomicilioService(DomicilioRepository domicilioRepository){ this.domicilioRepository = domicilioRepository; }

    @Override
    @Transactional
    public List<Domicilio> findAll() throws Exception {
        try {
            List<Domicilio> domicilios = domicilioRepository.findAll();
            return domicilios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> entityOptional=  domicilioRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try {
            entity = domicilioRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            Domicilio domicilio = entityOptional.get();
            domicilio = domicilioRepository.save(entity);
            return domicilio;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
