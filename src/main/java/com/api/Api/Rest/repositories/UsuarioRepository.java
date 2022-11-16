package com.api.Api.Rest.repositories;
import com.api.Api.Rest.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(
            value= "SELECT * FROM usuario WHERE email=:email",
            nativeQuery = true
    )
    Usuario findUsuario(String email);


}
