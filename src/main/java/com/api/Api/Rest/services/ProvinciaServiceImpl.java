package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Provincia;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService{

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(BaseRepository<Provincia, Long> baseRepository) {
        super(baseRepository);
    }

}
