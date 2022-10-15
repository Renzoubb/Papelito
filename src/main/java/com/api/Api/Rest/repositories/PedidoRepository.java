package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*JpaRepositoryclase generica que nos brinda todos los metodos necesarios para acceder a la bd  */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
