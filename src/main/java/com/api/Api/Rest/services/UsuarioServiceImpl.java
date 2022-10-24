package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.ProductoRepository;
import com.api.Api.Rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(BaseRepository<Usuario,Long> baseRepository){
        super(baseRepository);
    }

}