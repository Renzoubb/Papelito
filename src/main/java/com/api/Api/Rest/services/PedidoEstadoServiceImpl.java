package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.PedidoEstado;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.PedidoEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoEstadoServiceImpl extends BaseServiceImpl<PedidoEstado, Long> implements PedidoEstadoService {

    @Autowired
    private PedidoEstadoRepository pedidoEstadoRepository;
    public PedidoEstadoServiceImpl(BaseRepository<PedidoEstado,Long> baseRepository){
        super(baseRepository);
    }

}
