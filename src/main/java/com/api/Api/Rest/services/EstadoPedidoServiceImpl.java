package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.EstadoPedido;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoPedidoServiceImpl extends BaseServiceImpl<EstadoPedido, Long> implements EstadoPedidoService {

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;
    public EstadoPedidoServiceImpl(BaseRepository<EstadoPedido,Long> baseRepository){
        super(baseRepository);
    }

}
