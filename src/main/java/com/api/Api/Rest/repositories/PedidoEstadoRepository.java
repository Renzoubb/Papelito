package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.EstadoPedido;
import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.entities.PedidoEstado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoEstadoRepository extends BaseRepository<PedidoEstado,Long>{

    @Query(value = "SELECT * FROM pedido_estado R1 where R1.vigente = 1 AND R1.FK_PEDIDO = :idPedido",
            nativeQuery = true)
    PedidoEstado findPedidoEstadoVigente(@Param("idPedido")  Long idPedido);

    PedidoEstado findByPedidoIdAndVigente(Long idPedido, Boolean vigente);

    PedidoEstado findByPedidoId(Long idPedido);

}
