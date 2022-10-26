package com.api.Api.Rest.repositories;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {

}
