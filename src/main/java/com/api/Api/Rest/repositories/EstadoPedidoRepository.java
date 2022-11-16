package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.EstadoPedido;

public interface EstadoPedidoRepository extends BaseRepository<EstadoPedido,Long>{
    EstadoPedido findByNombreEstado(String nombre);

}
