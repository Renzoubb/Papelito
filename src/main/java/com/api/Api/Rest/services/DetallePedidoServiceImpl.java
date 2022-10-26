package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido,Long> baseRepository){
        super(baseRepository);
    }

}
