package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends BaseRepository<Ciudad,Long>  {

}
