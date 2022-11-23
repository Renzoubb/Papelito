package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.api.Api.Rest.entities.PedidoEstado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface CiudadRepository extends BaseRepository<Ciudad,Long>  {
    @Query(value = "SELECT * FROM ciudad R1 where R1.FK_PROVINCIA = :idProvincia",
            nativeQuery = true)
    List<Ciudad> findAllByIdProvincia(@Param("idProvincia")  Long idProvincia);
}
