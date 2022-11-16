package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long> {
    @Query(
            value= "SELECT * FROM producto WHERE fk_categoria=:categoria",
            nativeQuery = true
    )
    List<Producto> ProductosPorCategoria(@Param("categoria") int categoria);


    @Query(
            value= "SELECT * FROM producto WHERE fk_categoria=:categoria",
            countQuery = "SELECT count(*) FROM producto" ,
            nativeQuery = true
    )
    Page<Producto> ProductosPorCategoriaPage(@Param("categoria") int categoria, Pageable pageable);

    @Query(
            value= "SELECT * FROM producto WHERE nombre_producto LIKE %:nombre%",
            countQuery = "SELECT count(*) FROM producto" ,
            nativeQuery = true
    )
    Page<Producto> ProductosPorNombre(@Param("nombre") String nombre, Pageable pageable);

    List<Producto> findByDestacado(Boolean vigente);
    List<Producto> findByOferta(Boolean vigente);

}
