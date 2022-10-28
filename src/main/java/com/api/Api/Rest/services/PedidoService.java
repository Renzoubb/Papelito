package com.api.Api.Rest.services;

import com.api.Api.Rest.dtos.CreacionPedidoDTO;
import com.api.Api.Rest.dtos.PedidoDTO;
import com.api.Api.Rest.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    PedidoDTO createPedido(CreacionPedidoDTO creacionPedidoDTO) throws Exception;
    PedidoDTO getPedidoDetail(Long idPedido) throws Exception;
    List<PedidoDTO> getAllPedidosDetail(Pageable pageable) throws Exception;
}

