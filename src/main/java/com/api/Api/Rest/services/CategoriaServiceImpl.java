package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Categoria;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public CategoriaServiceImpl(BaseRepository<Categoria,Long> baseRepository){
        super(baseRepository);
    }
}
