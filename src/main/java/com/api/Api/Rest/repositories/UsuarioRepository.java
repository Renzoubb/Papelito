package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long> {


}
