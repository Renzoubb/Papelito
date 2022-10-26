package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.CiudadRepository;
import com.api.Api.Rest.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;
    public CiudadServiceImpl(BaseRepository<Ciudad,Long> baseRepository){
        super(baseRepository);
    }

}
