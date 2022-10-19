package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Categoria;
import com.api.Api.Rest.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long> {


}