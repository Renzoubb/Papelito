package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.Domicilio;
import com.api.Api.Rest.entities.EstadoPedido;
import com.api.Api.Rest.entities.PedidoEstado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long>{


    List<DetallePedido> findByPedidoId(Long idPedido);

}
