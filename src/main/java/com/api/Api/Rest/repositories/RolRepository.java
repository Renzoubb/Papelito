package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {

    Rol findByName(String name);
}
