package com.api.Api.Rest.services;

import com.api.Api.Rest.dtos.PedidoDTO;
import com.api.Api.Rest.entities.Pedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    PedidoDTO createPedido(PedidoDTO pedidoDTO) throws Exception;

}
