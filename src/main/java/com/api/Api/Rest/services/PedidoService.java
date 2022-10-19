package com.api.Api.Rest.services;


import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements BaseService<Pedido> {


    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    public List<Pedido> findAll() throws Exception {

        try {
            List<Pedido> entities = pedidoRepository.findAll();
            return entities;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido findById(Long id) throws Exception {

        try {
            Optional<Pedido> entityOptional=  pedidoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido save(Pedido entity) throws Exception {

        try {
            entity = pedidoRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido update(Long id, Pedido entity) throws Exception {
        try {
            Optional<Pedido> entityOptional = pedidoRepository.findById(id);
            Pedido pedido = entityOptional.get();
            pedido = pedidoRepository.save(entity);
            return pedido;

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {

        try {
            if(pedidoRepository.existsById(id)){
                pedidoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
